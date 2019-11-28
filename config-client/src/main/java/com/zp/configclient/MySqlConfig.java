package com.zp.configclient;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "mysql")
@Component
@Data
public class MySqlConfig {
    private String url;
}
