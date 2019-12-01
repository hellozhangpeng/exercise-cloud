package com.zp.admin.infrastructure.shiro;

import com.zp.admin.infrastructure.restful.AuthInfo;

/**
 * @Auther: ZhangPeng
 * @Date: 2019/11/29 09:38
 * @Description:
 */
public interface IAuthAdapter {
    boolean exist(AuthInfo authInfo);

    AuthInfo getAuth(String authIdentity);
}
