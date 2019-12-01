package com.zp.admin.infrastructure.jwt;

import com.zp.admin.infrastructure.spring.ApplicationContextHolder;
import com.zp.admin.infrastructure.utility.DateHelper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.lang3.tuple.Pair;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @Auther: ZhangPeng
 * @Date: 2019/11/28 16:02
 * @Description:
 */
public class JwtHelper {
    public static Pair generate(String subject) {
        JwtProperties jwtProperties = ApplicationContextHolder.getBean(JwtProperties.class);
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime expired = now.plusMinutes(jwtProperties.getTokenExpiredMinutes());
        JwtBuilder builder = Jwts.builder()
                .setId(UUID.randomUUID().toString())
                .setIssuer(jwtProperties.getIssuer())
                .setIssuedAt(DateHelper.LocalDateTimeToDate(now))
                .setSubject(subject)
                .setExpiration(DateHelper.LocalDateTimeToDate(expired))
                .signWith(signatureAlgorithm, jwtProperties.getSecret());
        return Pair.of(builder.compact(), expired);
    }

    public static Claims parse(String token) {
        JwtProperties jwtProperties = ApplicationContextHolder.getBean(JwtProperties.class);
        Claims claims = Jwts.parser().setSigningKey(jwtProperties.getSecret()).parseClaimsJws(token).getBody();
        return claims;
    }
}
