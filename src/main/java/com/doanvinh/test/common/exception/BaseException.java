package com.doanvinh.test.common.exception;

import lombok.Getter;
import lombok.With;

@Getter
public class BaseException extends RuntimeException {
    private final String messageCode;

    @With
    private Object data;

    public BaseException(String messageCode) {
        super(messageCode);
        this.messageCode = messageCode;
    }

    public BaseException(String messageCode, Object data) {
        super(messageCode);
        this.messageCode = messageCode;
        this.data = data;
    }
}
