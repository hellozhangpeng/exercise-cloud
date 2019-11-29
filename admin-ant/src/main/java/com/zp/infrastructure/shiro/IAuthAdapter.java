package com.zp.infrastructure.shiro;

import com.zp.infrastructure.restful.AuthInfo;

/**
 * @Auther: ZhangPeng
 * @Date: 2019/11/29 09:38
 * @Description:
 */
public interface IAuthAdapter {
    boolean exist(AuthInfo authInfo);

    AuthInfo getAuth(String authIdentity);
}
