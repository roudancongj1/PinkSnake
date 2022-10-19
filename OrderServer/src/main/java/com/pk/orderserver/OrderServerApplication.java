package com.pk.orderserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.sql.init.dependency.DatabaseInitializationDependencyConfigurer;

//@SpringBootApplication(scanBasePackages = { "com.pk" },exclude = {DataSourceAutoConfiguration.class})
@SpringBootApplication(scanBasePackages = { "com.pk" })
public class OrderServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderServerApplication.class, args);
    }

}
