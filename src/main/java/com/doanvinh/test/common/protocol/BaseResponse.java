package com.doanvinh.test.common.protocol;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.With;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record BaseResponse<T>(
        @With
        String code,
        @With
        String message,
        @With
        T data
) {

    public static final String SUCCESS_CODE = "1000";
    public static final String SUCCESS_MESSAGE = "Success";

    public static <T> BaseResponse<T> success() {
        return success(null);
    }

    public static <T> BaseResponse<T> success(T data) {
        return new BaseResponse<>(SUCCESS_CODE, SUCCESS_MESSAGE, data);
    }
}
