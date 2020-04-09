package com.projet.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * <p>
 *
 * @author cs12110 create at 2020-04-09 22:14
 * <p>
 * @since 1.0.0
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {
        "com.projet.feign"
})
public class OrderApp {

    public static void main(String[] args) {
        SpringApplication.run(OrderApp.class, args);
    }
}
