package com.zp.oauth;

import com.zp.infrastructure.restful.AuthInfo;
import com.zp.infrastructure.restful.RestResponse;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @PostMapping("login")
    public RestResponse login(@RequestBody AuthInfo authInfo) {
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(authInfo.getAuthIdentity(), authInfo.getPassword());
        Subject subject = SecurityUtils.getSubject();
        subject.login(usernamePasswordToken);
    }
}
