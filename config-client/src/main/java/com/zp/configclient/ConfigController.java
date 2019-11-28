package com.zp.configclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigController {
    @Autowired
    private MySqlConfig config;

    @Value("${mysql.url}")
    private  String url;

    @GetMapping("name")
    public String name(){
        return  config.getUrl();
    }
}
