package com.thanhtk.api.user.exception;

public class NoDataFoundException extends HandledException {
    public NoDataFoundException() {
        super("Not found data", 404);
    }

    public NoDataFoundException(String message) {
        super(message, 404);
    }

    public NoDataFoundException(Throwable throwable) {
        super("Not found data", 404, throwable);
    }

    public NoDataFoundException(String message, Throwable throwable) {
        super(message, 404, throwable);
    }

    public NoDataFoundException(String message, int code) {
        super(message, code);
    }

    public NoDataFoundException(String message, int code, Throwable throwable) {
        super(message, code, throwable);
    }
}
