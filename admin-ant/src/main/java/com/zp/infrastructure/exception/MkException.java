package com.zp.infrastructure.exception;

import java.text.MessageFormat;

/**
 * @Auther: ZhangPeng
 * @Date: 2019/11/28 16:39
 * @Description:
 */
public class MkException extends RuntimeException {

    private static final long serialVersionUID = 5556134820739483910L;

    public MkException(ApplicationExceptionCode exceptionCode, Throwable cause, Object... params) {
        super(MessageFormat.format(exceptionCode.toString(), params), cause);
    }

    public MkException(ApplicationExceptionCode errorCode, Object... params) {
        super(MessageFormat.format(errorCode.toString(), params));
    }
}
