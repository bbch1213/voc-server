package com.board.api.common.helper.exception;

public class LoginException extends RuntimeException {

    public LoginException() {
        super("존재하지 않는 아이디");
    }

    public LoginException(String id) {
        super(id + "의 비밀번호가 맞지 않습니다.");
    }
}
