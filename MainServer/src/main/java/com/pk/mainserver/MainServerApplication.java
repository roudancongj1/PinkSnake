package com.pk.mainserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(scanBasePackages = { "com.pk" })
@EnableDiscoveryClient
public class MainServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainServerApplication.class, args);
    }

}
