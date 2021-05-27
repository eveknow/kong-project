package com.thanhtk.api.middle.exception;

public class InternalException extends HandledException {

    public InternalException() {
        super("Internal Error", 500);
    }

    public InternalException(String message) {
        super(message, 500);
    }

    public InternalException(Throwable throwable) {
        super("Internal Error", 500, throwable);
    }

    public InternalException(String message, Throwable throwable) {
        super(message, 500, throwable);
    }

    public InternalException(String message, int code) {
        super(message, code);
    }

    public InternalException(String message, int code, Throwable throwable) {
        super(message, code, throwable);
    }
}
