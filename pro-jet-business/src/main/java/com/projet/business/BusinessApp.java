package com.projet.business;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author cs12110 create at 2020/4/9 19:16
 * @version 1.0.0
 */
@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages = {
        "com.projet"
})
@EnableFeignClients(basePackages = {
        "com.projet.feign"
})
public class BusinessApp {

    public static void main(String[] args) {
        SpringApplicationBuilder springApplicationBuilder = new SpringApplicationBuilder(BusinessApp.class);
        springApplicationBuilder.bannerMode(Banner.Mode.OFF);

        SpringApplication application = springApplicationBuilder.build();
        application.run(args);
    }
}
