package com.zp.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {
    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/get")
    public Object get() {
        return discoveryClient.getInstances("producer-hello");
    }
}

