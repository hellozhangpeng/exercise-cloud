package com.zp.admin.infrastructure;

import com.zp.admin.infrastructure.exception.ApplicationExceptionCode;

/**
 * @Auther: ZhangPeng
 * @Date: 2019/11/29 16:21
 * @Description:
 */
public enum InfrastructureExceptionCode implements ApplicationExceptionCode {
    ;

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    private String code;
    private String message;

    InfrastructureExceptionCode(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
