package com.board.api.voc.form;

import com.board.api.common.base.BaseForm;
import com.board.api.voc.enumerate.VocStatus;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

public class VocForm {

    public static class Request {

        @Data
        @Getter
        @Setter
        public static class Register {
            private String customerId;
            private String title;
            private String content;
        }

    }

    public static class Response {

        @Data
        public static class VocList {
            private long id;
            private String title;
            private String customerId;
            private VocStatus vocStatus;
            private LocalDateTime createdAt;
        }

        @Data
        public static class VocPage {
            private String customerId;
            private String title;
            private String content;
            private VocStatus vocStatus;
            private LocalDateTime createdAt;
            private BaseForm.Response.Account user;
        }

        @Data
        public static class Register {
            private String code;
            private String message;
        }
    }
}
