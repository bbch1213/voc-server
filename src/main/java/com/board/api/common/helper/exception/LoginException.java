package com.board.api.common.helper.exception;

public class LoginException extends RuntimeException {

    public LoginException() {
        super("존재하지 않는 아이디");
    }
}
