package com.board.api.common.helper.exception;

public class LoginException extends RuntimeException {

    public LoginException() {
        super("아이디나 비밀번호를 확인해주세요.");
    }
}
