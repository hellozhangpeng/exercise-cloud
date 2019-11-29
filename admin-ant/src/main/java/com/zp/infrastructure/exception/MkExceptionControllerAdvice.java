package com.zp.infrastructure.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 * @Auther: ZhangPeng
 * @Date: 2019/11/29 16:51
 * @Description:
 */
@ControllerAdvice
public class MkExceptionControllerAdvice {
    public ResponseEntity handle(MkException exception) {
        HttpStatus status = HttpStatus.SERVICE_UNAVAILABLE;
        return new ResponseEntity(exception.getMessage(), status);
    }

    public ResponseEntity handle(Exception exception) {
        HttpStatus status = HttpStatus.SERVICE_UNAVAILABLE;
        return new ResponseEntity(exception.getCause() == null ? exception.getMessage() : exception.getCause().getMessage(), status);
    }
}
