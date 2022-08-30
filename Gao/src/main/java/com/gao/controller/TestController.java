package com.gao.controller;


import com.gao.pojo.JsonTree;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
@RequestMapping("test")
public class TestController {

    private static final Logger log = LoggerFactory.getLogger(TestController.class);

    @PostMapping("fir")
    public String fir(@RequestBody List<Map<String,Object>> JsonList){

        try {
            //1 2 3为一层 1-1 1-2 2-1 2-2为一层 1-1-1 1-1-2 2-1-1为一层并排序
            List<Map<String, Object>> lev1 = JsonList.stream()
                    .filter(map -> ( map.get("b").toString().trim().split(" ")[1].split("-").length == 1))
                    .sorted(Comparator.comparingInt(map -> (Integer.parseInt(map.get("b").toString().trim().split(" ")[1]))))
                    .collect(Collectors.toList());

            List<Map<String, Object>> lev2 = JsonList.stream()
                    .filter(map -> ( map.get("b").toString().trim().split(" ")[1].split("-").length == 2))
                    .sorted(Comparator.comparingInt(map -> (Integer.parseInt(map.get("b").toString().trim().split(" ")[1].split("-")[1]))))
                    .collect(Collectors.toList());

            List<Map<String, Object>> lev3 = JsonList.stream()
                    .filter(map -> ( map.get("b").toString().trim().split(" ")[1].split("-").length == 3))
                    .sorted(Comparator.comparingInt(map -> (Integer.parseInt(map.get("b").toString().trim().split(" ")[1].split("-")[2]))))
                    .collect(Collectors.toList());

            //从第三层开始遍历，上级合同第x个时将child里上标为x的put进上级
            for (int i = 1; i <= lev1.size(); i++) {
                for (int j = 0; j <= lev2.size(); j++) {
                    for (int k = 0; k <= lev3.size(); k++) {
                        if(Integer.parseInt(lev3.get(k).toString().trim().split(" ")[1].split("-")[2])== j){
                            lev2.get(j).put("children",lev3.get(k));
                        };
                    }
                    if(Integer.parseInt(lev2.get(j).toString().trim().split(" ")[1].split("-")[1])== i){
                        lev1.get(j).put("children",lev2.get(j));
                    };
                }
            }
            return lev1.toString();
        } catch (Exception e) {
            log.error("转换异常\n");
            e.printStackTrace();
            return "JSON转换异常";
        }

    }


    /*
    * 日期
    * */
    @GetMapping("sec")
    public String sec(){

        //也可以用2022*10000+02*100+11 作比较排序后判断例如if(20220211 + 1 == arg[nextNum]) 相当于手写时间戳

        System.out.println("相隔一天时间戳 dayCount * 24 * 60 * 60 * 1000 == 86400000");

        List<String> dateList = Arrays.asList("2022-02-11", "2022-02-09", "2021-12-29", "2021-12-30", "2021-12-31", "2022-01-01", "2022-01-05", "2022-01-06", "2022-01-07", "2022-02-11", "2022-02-11", "2022-02-11", "2022-02-11", "2022-02-12");
        List<Long> timeMilliList = new ArrayList<>();

        //根据时间戳排序
        dateList = dateList.stream().sorted(Comparator.comparingLong(dateStr ->{
            LocalDate parse = LocalDate.parse(dateStr);
            long l = parse.atStartOfDay(ZoneOffset.ofHours(8)).toInstant().toEpochMilli();
            return l;
        })).distinct().collect(Collectors.toList());

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < dateList.size(); i++) {
            if (i == 0) {
                sb.append(dateList.get(0));
                continue;
            }
            if (i != dateList.size() - 2){
                if(LocalDate.parse(dateList.get(i + 1)).atStartOfDay(ZoneOffset.ofHours(8)).toInstant().toEpochMilli()
                        - LocalDate.parse(dateList.get(i)).atStartOfDay(ZoneOffset.ofHours(8)).toInstant().toEpochMilli() != 86400000L &&
                        LocalDate.parse(dateList.get(i + 2)).atStartOfDay(ZoneOffset.ofHours(8)).toInstant().toEpochMilli()
                                - LocalDate.parse(dateList.get(i+1)).atStartOfDay(ZoneOffset.ofHours(8)).toInstant().toEpochMilli() != 86400000L){
                    sb.append("至" + dateList.get(i));
                    sb.append("," + dateList.get(i + 1));
                    sb.append("," + dateList.get(i + 2));
                    i=i+1;
                } else if (LocalDate.parse(dateList.get(i + 1)).atStartOfDay(ZoneOffset.ofHours(8)).toInstant().toEpochMilli()
                        - LocalDate.parse(dateList.get(i)).atStartOfDay(ZoneOffset.ofHours(8)).toInstant().toEpochMilli() != 86400000L) {
                    sb.append("至" + dateList.get(i));
                    sb.append("," + dateList.get(i + 1));
                }

            }else {
                if(LocalDate.parse(dateList.get(i + 1)).atStartOfDay(ZoneOffset.ofHours(8)).toInstant().toEpochMilli()
                        - LocalDate.parse(dateList.get(i)).atStartOfDay(ZoneOffset.ofHours(8)).toInstant().toEpochMilli() != 86400000L){
                    sb.append(","+dateList.get(i));
                    sb.append(","+ dateList.get(i+1));
                    break;
                }else {
                    sb.append("至" + dateList.get(i+1));
                    break;
                }
            }

        }
        //调整格式
        String[] strings = sb.toString().split(",");
        List<String> req = new ArrayList<>();
        Collections.addAll(req,strings);
        System.out.println(dateList);
        System.out.println(req);
        return req.toString();

    }
    //时间戳转Instant.ofEpochMilli(ZoneOffset.ofHours(8)).atZone().toLocalDateTime()
    //加一天localDate.plusDays(1);timeMilliList

    @GetMapping("ee")
    public String ee(){

        ArrayList<Object> list = new ArrayList<>();

        String aa=null;
        list.add("");
        list.add(aa);

        Set<Object> set = new HashSet<>();

        set.add("");
        set.add(aa);

        System.out.println(list.size());
        System.out.println(set.size());
        return "ok";
    }
}
