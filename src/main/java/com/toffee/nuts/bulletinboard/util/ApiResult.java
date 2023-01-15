package com.toffee.nuts.bulletinboard.util;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ApiResult<T> {
    private final T data;
    private final String message;

    public static <T> ApiResult<T> succeed(T data) {
        return new ApiResult<>(data, null);
    }

    public static <T> ApiResult<T> failed(Throwable throwable) {
        return new ApiResult<>(null, throwable.getMessage());
    }

    public static <T> ApiResult<T> failed(String message) {
        return new ApiResult<>(null, message);
    }

}
