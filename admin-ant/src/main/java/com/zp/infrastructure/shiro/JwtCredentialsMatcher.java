package com.zp.infrastructure.shiro;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.JWTVerifier;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;

/**
 * @Auther: ZhangPeng
 * @Date: 2019/11/28 17:25
 * @Description:
 */
public class JwtCredentialsMatcher implements CredentialsMatcher {
    @Override
    public boolean doCredentialsMatch(AuthenticationToken authenticationToken, AuthenticationInfo authenticationInfo) {
        Algorithm algorithm = Algorithm.HMAC256();
        JWTVerifier verifier = JWT.require(algorithm)
                .withClaim("username", authenticationInfo.getPrincipals())
                .build();
        verifier.verify(authenticationToken.getPrincipal());
        return false;
    }
}
