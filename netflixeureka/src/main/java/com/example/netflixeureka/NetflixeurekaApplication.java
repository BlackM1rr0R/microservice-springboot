package com.example.netflixeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class NetflixeurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(NetflixeurekaApplication.class, args);
    }

}
