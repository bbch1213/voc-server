package com.board.api.account.form;

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
            private String result;
            private String token;
        }
    }
}
