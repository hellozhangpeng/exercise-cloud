package com.zp.infrastructure.jwt;

import lombok.Data;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Auther: ZhangPeng
 * @Date: 2019/11/29 09:50
 * @Description:
 */
@ConfigurationProperties(prefix = "mk.jwt")
@Component
@Data
public class JwtProperties {
    /**
     * 密钥
     */
    private String secret;
    /**
     * 加密算法
     */
    private String algorithmName = Sha256Hash.ALGORITHM_NAME;
    /**
     * token过期分钟数
     */
    private int tokenExpiredMinutes = 60 * 24;
    /**
     * jwt签发者
     */
    private String issuer;
}
