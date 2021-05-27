package com.thanhtk.service.tracking.exception;

import lombok.Getter;

@Getter
class ExceptionBody {
    private final long timestamp;
    private final String message;
    private final Integer errorCode;


    private ExceptionBody(long timestamp, String message, Integer errorCode) {
        this.timestamp = timestamp;
        this.message = message;
        this.errorCode = errorCode;
    }


    static ExceptionBody of(long timestamp, String message, Integer errorCode) {
        return new ExceptionBody(timestamp, message, errorCode);
    }
}
