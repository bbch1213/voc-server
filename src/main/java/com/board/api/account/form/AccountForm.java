package com.board.api.account.form;

import com.board.api.role.entity.Role;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

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
            private List<Role> role;
        }
    }
}
