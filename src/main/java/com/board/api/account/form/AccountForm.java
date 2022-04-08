package com.board.api.account.form;

import com.board.api.account.enumerate.AccountRole;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

public class AccountForm {

    public static class Request {

        @Data
        @Getter
        @Setter
        public static class Login {
            private String userId;
            private String password;
        }

    }

    public static class Response {

        @Data
        @Getter
        @Setter
        public static class Login {
            private String userId;
            private String token;
            private AccountRole role;
        }
    }
}
