package com.pk.orderserver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
@RestController
@RequestMapping("order")
public class OrderController {

    @GetMapping("test")
    public String test(){


        return "订单号为xxxxxxxxxxx";
    }
}
