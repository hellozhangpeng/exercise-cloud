package com.zp.admin.infrastructure.shiro;

import com.zp.admin.infrastructure.restful.AuthInfo;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

/**
 * @Auther: ZhangPeng
 * @Date: 2019/11/28 17:01
 * @Description:
 */
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private IAuthAdapter authAdapter;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return new SimpleAuthorizationInfo();
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        AuthInfo authInfo = authAdapter.getAuth((String)authenticationToken.getPrincipal());
        if (Objects.isNull(authInfo)) {
            return null;
        }
        return new SimpleAuthenticationInfo(authInfo.getAuthIdentity(), authInfo.getPassword(), ByteSource.Util.bytes(authInfo.getSaltCode()), getName());
    }
}
