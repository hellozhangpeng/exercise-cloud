package com.zp.admin.admin;

import com.zp.admin.infrastructure.restful.AuthInfo;
import com.zp.admin.infrastructure.shiro.IAuthAdapter;
import org.springframework.stereotype.Service;

/**
 * @author 张鹏
 * @email 365072035@qq.com
 * @time 2019/12/1 20:31
 */
@Service
public class AuthService implements IAuthAdapter {

  @Override
  public boolean exist(AuthInfo authInfo) {
    return false;
  }

  @Override
  public AuthInfo getAuth(String authIdentity) {
    return null;
  }
}
