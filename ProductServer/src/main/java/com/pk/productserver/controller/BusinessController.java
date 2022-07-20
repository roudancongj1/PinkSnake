package com.pk.productserver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RequestMapping("business")
@RestController
public class BusinessController {



    @GetMapping("test")
    public String test(){

        RestTemplate template = new RestTemplate();
        String object = template.getForObject("http://localhost:8901/order/test", String.class);
        return "查询成功:"+object;
    }

}
