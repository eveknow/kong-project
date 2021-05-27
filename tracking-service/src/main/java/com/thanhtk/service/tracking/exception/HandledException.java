package com.thanhtk.service.tracking.exception;

import lombok.Getter;

@Getter
public class HandledException extends Exception {
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
