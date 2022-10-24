package com.pk.mainserver.controller;

import com.alibaba.fastjson.JSON;
import com.pk.commonserver.pojo.AVB;
import com.pk.commonserver.pojo.Business;
import com.pk.commonserver.util.MqTopic;
import com.pk.commonserver.util.TopicBy;
import com.pk.mainserver.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.SendStatus;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RequestMapping("business")
@RestController
@Api(tags = "合同管理")
public class BusinessController {

    @Autowired
    private RocketMQTemplate stockMqTemplate;
    @Autowired
    private AVB avb1;
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private OrderService orderService;


    @GetMapping("test")
    public String test(){
        AVB avb = new AVB();
        avb.setA("aaaa");
        avb.setB("BBBB");
        System.out.println(avb);

        RestTemplate template = new RestTemplate();
        String object = template.getForObject("http://localhost:8901/order/test", String.class);
        return "查询成功:"+object;
    }

    @PostMapping("test2")
    @ApiOperation("get2")
    public String test2(@RequestBody Business business){

        return "查询成功:";
    }

    @GetMapping("test3")
    @ApiOperation("get3")
    public String test3(){
        AVB avb = new AVB();
        avb.setA("AAAAAAAAAAAAAAAA");
        avb.setB("BBBBBBBBBBBBBBBB");
        ArrayList<AVB> list = new ArrayList<>();
        list.add(avb);
        SendResult syncSend = stockMqTemplate.syncSend(TopicBy.ORDER, list);
        SendResult syncSend2 = stockMqTemplate.syncSend(TopicBy.PRODUCT, "body");

        if (syncSend.getSendStatus() == SendStatus.SEND_OK && syncSend2.getSendStatus() == SendStatus.SEND_OK)
            return "发送成功:";
        else
            return "发送失败";
    }

    @GetMapping("test4")
    @ApiOperation("get4")
    public String test4(){
        List<String> services = discoveryClient.getServices();
        List<ServiceInstance> instances = discoveryClient.getInstances("OrderServer");
        String url = "http://"+instances.get(0).getHost() +":"+ instances.get(0).getPort()+ "/order/test";
        String forObject = restTemplate.getForObject(url, String.class);

        return forObject;

    }

    @GetMapping("test5")
    @ApiOperation("get5")
    public String test5(){

        return orderService.getOrder();

    }

}
