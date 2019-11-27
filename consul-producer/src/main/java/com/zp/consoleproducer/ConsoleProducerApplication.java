package com.zp.consoleproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ConsoleProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsoleProducerApplication.class, args);
    }

}
