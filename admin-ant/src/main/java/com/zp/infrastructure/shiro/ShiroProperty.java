package com.zp.infrastructure.shiro;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Auther: ZhangPeng
 * @Date: 2019/11/28 16:41
 * @Description:
 */
@Component
@ConfigurationProperties(prefix = "shiro")
@Data
public class ShiroProperty {
    private String secret;
}
