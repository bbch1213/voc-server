package com.board.api.common.base;

import lombok.Data;

public class BaseForm {

    public static class Response {

        @Data
        public static class Account {
            private Long id;
            private String userId;
        }
    }
}
