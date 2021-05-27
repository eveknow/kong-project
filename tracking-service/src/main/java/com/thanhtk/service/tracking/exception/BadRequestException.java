package com.thanhtk.service.tracking.exception;

public class BadRequestException extends HandledException {
    public BadRequestException() {
        super("Bad Request", 400);
    }

    public BadRequestException(String message) {
        super(message, 400);
    }

    public BadRequestException(Throwable throwable) {
        super("Bad Request", 400, throwable);
    }

    public BadRequestException(String message, Throwable throwable) {
        super(message, 400, throwable);
    }

    public BadRequestException(String message, int code) {
        super(message, code);
    }

    public BadRequestException(String message, int code, Throwable throwable) {
        super(message, code, throwable);
    }
}
