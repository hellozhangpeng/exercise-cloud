package com.zp.infrastructure.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;

/**
 * @Auther: ZhangPeng
 * @Date: 2019/11/28 17:25
 * @Description:
 */
public class ShiroCredentialsMatcher extends HashedCredentialsMatcher {
    @Override
    public boolean doCredentialsMatch(AuthenticationToken authenticationToken, AuthenticationInfo authenticationInfo) {
        boolean valid = super.doCredentialsMatch(authenticationToken, authenticationInfo);
        return valid;
    }
}
