package com.zp.oauth;

import com.zp.infrastructure.jwt.JwtHelper;
import com.zp.infrastructure.restful.AuthInfo;
import com.zp.infrastructure.restful.RestResponse;
import com.zp.infrastructure.shiro.IAuthAdapter;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class AuthController {
    @Autowired
    private IAuthAdapter adapter;

    @PostMapping("login")
    public RestResponse login(@RequestBody AuthInfo authInfo) {
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(authInfo.getAuthIdentity(), authInfo.getPassword());
        Subject subject = SecurityUtils.getSubject();
        subject.login(usernamePasswordToken);

        Pair<String, LocalDateTime> jwtPair = JwtHelper.generate("ser");
        return RestResponse.success(jwtPair);
    }
}
