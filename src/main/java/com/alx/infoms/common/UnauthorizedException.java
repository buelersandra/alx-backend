package com.alx.infoms.common;

public class UnauthorizedException extends Exception {
    private String message;

    public UnauthorizedException(String message){
        super(message);
        this.message=message;
    }

    public UnauthorizedException() {}
}
