package com.zp.infrastructure.shiro;

import com.zp.infrastructure.restful.AuthInfo;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * @Auther: ZhangPeng
 * @Date: 2019/11/28 17:01
 * @Description:
 */
public class JwtRealm extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return new SimpleAuthorizationInfo();
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        AuthInfo authInfo = new AuthInfo();
        //获取到用户

        return new SimpleAuthenticationInfo(authInfo.getAuthIdentity(), authInfo.getPassword(), authInfo.getSaltCode());
    }
}
