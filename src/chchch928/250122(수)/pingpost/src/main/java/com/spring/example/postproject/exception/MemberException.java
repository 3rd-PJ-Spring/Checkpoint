package com.spring.example.postproject.exception;

import lombok.Getter;

@Getter
public class MemberException extends RuntimeException {
    private final ErrorCode errorCode;

    public MemberException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public MemberException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }
}
