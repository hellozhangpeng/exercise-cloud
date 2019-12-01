package com.zp.admin.infrastructure.restful;

import lombok.Data;

@Data
public class RestResponse {

    private String code;

    private String message;

    private boolean success;

    private Object result;

    public static RestResponse success(Object result) {
        RestResponse restResponse = new RestResponse();
        return restResponse;
    }

}
