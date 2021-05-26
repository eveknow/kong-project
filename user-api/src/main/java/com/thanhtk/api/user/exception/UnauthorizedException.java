package com.thanhtk.api.user.exception;

public class UnauthorizedException extends HandledException {
    public UnauthorizedException() {
        super("You are not authorized", 401);
    }

    public UnauthorizedException(String message, int code) {
        super(message, code);
    }
}
