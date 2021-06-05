package com.thanhtk.api.product.exception;

import lombok.Getter;

@Getter
public class HandledException extends RuntimeException {
    private final int code;

    HandledException(String message, int code) {
        super(message);
        this.code = code;
    }

    HandledException(String message, int code, Throwable throwable) {
        super(message, throwable);
        this.code = code;
    }
}
