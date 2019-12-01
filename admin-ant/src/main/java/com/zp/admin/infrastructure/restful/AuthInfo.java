package com.zp.admin.infrastructure.restful;

import lombok.Data;

@Data
public class AuthInfo {
    private String authIdentity;

    private String password;

    private String saltCode;
}
