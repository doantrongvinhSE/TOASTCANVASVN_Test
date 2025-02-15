package com.doanvinh.test.common.exception;

import com.doanvinh.test.common.protocol.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private final static String ERROR_CODE = "00";

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BaseException.class)
    public BaseResponse<?> handleBaseException(BaseException ex) {
        return new BaseResponse<>(ERROR_CODE, ex.getMessageCode(), ex.getData());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BaseResponse<?> handleValidException(MethodArgumentNotValidException exception) {
        return new BaseResponse<>(ERROR_CODE, exception.getFieldError().getDefaultMessage(), null);
    }
}
