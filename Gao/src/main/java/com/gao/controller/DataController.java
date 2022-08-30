package com.gao.controller;

import com.gao.dao.TestUserMapper;
import com.gao.pojo.TestUser;

import com.gao.service.eService;
import com.gao.util.EAsync;
import com.gao.util.RamSession;
import com.gao.util.Renum;
import com.gao.util.lamadaUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.ExtractingResponseErrorHandler;
import org.springframework.web.client.RestTemplate;


import java.io.IOException;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

import static com.gao.util.Renum.ERRORERROR;
import static com.gao.util.Renum.OKOK;
import static java.util.concurrent.TimeUnit.SECONDS;

@RestController
public class DataController {
    private static final Logger log = LoggerFactory.getLogger(webController.class);

    @Autowired
    private TestUserMapper testUserMapper;

    @Autowired
    private eService eservice;
    @RequestMapping("tt")
    public List<TestUser> tt(){

        TestUser user = new TestUser();
        String name = user.getName();
        System.out.println(       name);

        String name1="你好";
        String name2="你好";
        String name3="你好2222";
        Set<String> set = new HashSet<>();

        set.add(name1);
        set.add(name2);
        set.add(name3);
        System.out.println(set);

        StringBuffer stringBuffer = new StringBuffer();
        System.out.println(        stringBuffer.toString());

        lamadaUtil lamadaUtil = new lamadaUtil() {
            @Override
            public TestUser add(TestUser testUser) {
                System.out.println("接口111");
                return null;
            }
        };

        TestUser ts = lamadaUtil.add(new TestUser());
        lamadaUtil lamadaUtil2 = testUser -> {
            System.out.println("lamda111");
            return testUser;
        };
        lamadaUtil2.add(new TestUser());


        return testUserMapper.queryAll();
    }

    @RequestMapping("ii")
    public int ii(TestUser testUser){
        int i = testUserMapper.insertOne(testUser);
        return i;
    }

    @RequestMapping("jj")
    public int jj(@RequestBody TestUser testUser){


        /*new ConcurrentHashMap<>()
                new ConcurrentMap<>()*/

        return testUserMapper.insertOne(testUser);
    }

    @GetMapping("pool")
    public String ThreadPool(@RequestParam(required = false) String param){
        //线程队列 先进先出
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1,10,30, SECONDS,new LinkedBlockingDeque<>(2));
        //Executors.newCachedThreadPool()
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            executor.execute(()->{
                log.info("线程"+ finalI +"开始");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.info("线程"+ finalI +"结束");

            });
        }
        executor.shutdown();
        return "您访问了接口:您的参数是"+param;
    }


    @GetMapping("enum")
    public String enum1(){
        System.out.println(OKOK);
        System.out.println(OKOK.name());
        //System.out.println(OKOK.getName());
        /*for (Renum value : Renum.values()) {
            System.out.println(value.getName()+ "-----" + value.name());
        }*/
        System.out.println(OKOK);

        System.out.println(SECONDS);
        System.out.println(SECONDS);


        //return ERRORERROR.getName();
        //return TimeUnit.SECONDS.name();
        RestTemplate restTemplate = new RestTemplate();
        String forObject = restTemplate.getForObject("http://localhost:88/test/sec",String.class);
        System.out.println(forObject);
        return ERRORERROR.name();
    }

    @RequestMapping("list")
    public String list(){

        List<String> list = new ArrayList<>();
        String list2[]={"1","2","3","4"};

        String l1="你好1";
        String l2="你好1";
        String l3="你好3";
        String l4="你好4";

        list.add(l1);
        list.add(l2);
        list.add(l3);
        list.add(l4);

        list = list.stream().distinct().collect(Collectors.toList());
        String collect = Arrays.stream(list2).distinct().collect(Collectors.joining());
        System.out.println(list);
        System.out.println(collect);

        list.stream().filter(s -> s==null).forEach(System.out::println);

        return "";
    }

    @RequestMapping("go")
    public String go(){
        RestTemplate template = new RestTemplate();

        //String object = template.getForObject("http://127.0.0.1:88/t1/{aa}",String.class,"aa");
        //String s = template.postForObject("http://127.0.0.1:88/t1", "参数", String.class);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json;charset=utf8");

        HashMap<String, Object> map = new HashMap<>();
        map.put("a","1");
        HttpEntity<Object> entity = new HttpEntity<>(map,headers);
        ResponseEntity<String> response = template.exchange("http://127.0.0.1:88/t1", HttpMethod.POST, entity, String.class);

        System.out.println(        response.getStatusCode());

        System.out.println(response);

        //System.out.println(s);
        //System.out.println(object);
        return "访问转发接口成功";
    }
    @GetMapping("t1/{str}")
    public String t1(@PathVariable(required = false) String str){
        
        return "您访问了接口:您的参数是"+str;
    }

    @PostMapping("t1")
    public String t2(@RequestBody Map map){

        return "您访问了接口:您的参数是"+map.toString();
    }

    @RequestMapping("go2")
    public String go2() {
        RestTemplate tp = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        tp.setErrorHandler(new DefaultResponseErrorHandler(){
            @Override
            public void handleError(ClientHttpResponse clientHttpResponse) throws IOException {
                // 只要重写此方法，不去抛出HttpClientErrorException异常即可
                //HttpStatus statusCode = clientHttpResponse.getStatusCode();
                //log.error("错误码::[{}]",statusCode);
                //System.out.println(clientHttpResponse.getBody());
            }
        });
        /*tp.setErrorHandler(new ExtractingResponseErrorHandler(){
            @Override
            protected byte[] getResponseBody(ClientHttpResponse response) {
                return super.getResponseBody(response);
            }
        });*/
        String s = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>\n" +
                "<SOAP-ENV:Envelope xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:enc=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:env=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" SOAP-ENV:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\">\n" +
                "  <SOAP-ENV:Header />\n" +
                "  <SOAP-ENV:Body>\n" +
                "    <swbep:updateBusiness xmlns:swbep=\"urn:SicsWsBusinessEntryPoint\">\n" +
                "      <genericInput />\n" +
                "      <updateBusinessInput>\n" +
                "        <businessReference>\n" +
                "        <businessReference>\n" +
                "          <identifier>IPT100500</identifier>\n" +
                "        </businessReference>\n" +
                "        <businessUpdate>\n" +
                "          <title>QHTEST620</title>\n" +
                "        </businessUpdate>\n" +
                "      </updateBusinessInput>\n" +
                "    </swbep:updateBusiness>\n" +
                "  </SOAP-ENV:Body>\n" +
                "</SOAP-ENV:Envelope>";
        headers.add("Content-Type", "application/json;charset=utf8");
        headers.add("SOAPAction", "http://www.SicsWsBusinessPartnerEntryPoint.com/SicsWsBusinessPartnerEntryPoint-interface/");
        HttpEntity<Object> entity = new HttpEntity<>(s, headers);
        ResponseEntity<String> response = tp.exchange("http://39.105.121.190:8080/SicsServerPC/SicsWSServlet", HttpMethod.POST, entity, String.class);
        System.out.println(response.getStatusCode().value());
        System.out.println(response.getBody());
        return "访问转发接口成功";
    }

    @GetMapping("t3")
    public String t3(@RequestParam(required = false) String param){
        String callback = callback(param,false,true);
        return "您访问了接口:您的参数是"+param+"返回值是"+callback;
    }

    private String callback(String param,boolean... isNewSection){
        boolean[] bb={true,true,true};
        Boolean[] dd={true,true,true};
        String[] aa={"true","true","true"};
        Integer[] cc={1,2,3};
        Arrays.stream(dd).forEach(b->{
            Optional.ofNullable(b).ifPresent(pp ->{
                pp=!pp;
                pp.toString();
            });
            //Optional.ofNullable(b).map(b).ore
        });


        if (param == null){
            param="参数为空";
        }
        /*PatientInfo patientInfo = patientInfoDao.getPatientInfoById(consultOrder.getPatientId());
if (patientInfo != null) {
    consultInfoResp.setPatientHead(patientInfo.getHead());
}

// 使用Optional 和函数式编程，一行搞定，而且像说话一样
Optional.ofNullable(patientInfo).ifPresent(p -> consultInfoResp.setPatientHead(p.getHead()));
*/
        /*public static String getChampionName(Competition comp) throws IllegalArgumentException {
    if (comp != null) {
        CompResult result = comp.getResult();
        if (result != null) {
            User champion = result.getChampion();
            if (champion != null) {
                return champion.getName();
            }
        }
    }
    throw new IllegalArgumentException("The value of param comp isn't available.");
}
*/
        /*public static String getChampionName(Competition comp) throws IllegalArgumentException {
    return Optional.ofNullable(comp)
            .map(Competition::getResult)  // 相当于c -> c.getResult()，下同
            .map(CompResult::getChampion)
            .map(User::getName)
            .orElseThrow(()->new IllegalArgumentException("The value of param comp isn't available."));
}
*/
        /*PatientInfo patientInfo = patientInfoDao.getPatientInfoById(consultOrder.getPatientId());
if (patientInfo != null) {
    consultInfoResp.setPatientHead(patientInfo.getHead());
}

// 使用Optional 和函数式编程，一行搞定，而且像说话一样
Optional.ofNullable(patientInfo).ifPresent(p -> consultInfoResp.setPatientHead(p.getHead()));
*/
        return "{"+param+isNewSection[0]+"}";
    }

    @PostMapping("t4")
    public String t4(@RequestBody List<String> param){
        Iterator<String> iterator = param.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
            break;
        }
        return "您访问了接口:您的参数是"+param;
    }

    @GetMapping("t5")
    public String t5(@RequestParam @Nullable List<String> param){
        Optional.ofNullable(param).ifPresent(System.out::println);
        Optional<List<String>> strings = Optional.ofNullable(param).filter(p -> p.size() > 5);

        return "您访问了接口:您的参数是"+param;
    }

    @GetMapping("t6")
    public String t6(@RequestParam @Nullable List<String> param){
        lamadaUtil util = testUser -> {
            System.out.println(testUser);
            return testUser;
        };
        Runnable runnable = () -> System.out.println("xx");

        System.out.println(OKOK.name());
        System.out.println(OKOK);

        //int a = 1/0;
        //System.out.println(a);
        try {

        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        eservice.e();



        return "您访问了接口:您的参数是"+param;
    }
    //form-data
    @GetMapping("t7")
    public String t7(@RequestParam @Nullable List<String> param) throws Exception {

        //EAsync.run(()-> {
        //    System.out.println("任务开始");
        //    try {
        //        Thread.sleep(3000);
        //        System.out.println("任务结束");
        //    } catch (InterruptedException e) {
        //        e.printStackTrace();
        //    }

        //});

        ExecutorService service = Executors.newFixedThreadPool(10);
        Future<?> future = service.submit(()->{
            System.out.println("任务开始");
                try {
                    Thread.sleep(3000);
                    System.out.println("任务结束");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "";
        });
        future.get();


        service.execute(()->{
            System.out.println("任务开始");
            try {
                Thread.sleep(3000);
                System.out.println("任务结束");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        service.execute(()->{
            System.out.println("任务开始");
            try {
                Thread.sleep(3000);
                System.out.println("任务结束");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        return "您访问了接口:您的参数是"+param;
    }

    @PostMapping("t8")
    public String t8(@RequestParam String param){

        String a = "abcdefg";
        String[] split = a.split("");
        Arrays.stream(split).forEach(System.out::println);

        String 输出 = "输出输出";

        System.out.println(输出);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("requestID","adsadas");
        RamSession.set(hashMap);
        System.out.println(RamSession.get());




        return "您访问了接口:您的参数是" + param;
    }

    
}
