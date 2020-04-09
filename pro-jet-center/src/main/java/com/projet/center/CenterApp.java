package com.projet.center;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author cs12110 create at 2020/4/9 19:21
 * @version 1.0.0
 */
@SpringBootApplication
@EnableEurekaServer
public class CenterApp {

    public static void main(String[] args) {
        SpringApplication.run(CenterApp.class, args);
    }
}
