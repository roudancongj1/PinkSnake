package com.pk.mainserver.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "OrderServer")
public interface OrderService {

    @GetMapping("order/test")
    String getOrder();
}
