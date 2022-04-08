package com.board.api.common.base;

import lombok.Data;

public class BaseForm {

    public static class Request {
        @Data
        public static class Account {
            private String token;
            private String userId;
        }
    }

    public static class Response {

        @Data
        public static class Account {
            private Long id;
            private String userId;
        }
    }
}
