package com.board.api.common.helper.exception;

public class AuthenticationException extends RuntimeException {

    public AuthenticationException() {
        super("인증정보가 맞지 않습니다.");
    }
}
