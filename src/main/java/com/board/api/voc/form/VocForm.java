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
            private String title;
            private String content;
        }

    }

    public static class Response {

        @Data
        public static class VocList {
            private long id;
            private String title;
            private VocStatus vocStatus;
            private LocalDateTime createdAt;
            private BaseForm.Response.Account createdBy;
        }

        @Data
        public static class VocPage {
            private String title;
            private String content;
            private VocStatus vocStatus;
            private LocalDateTime createdAt;
            private BaseForm.Response.Account createdBy;
            private BaseForm.Response.Account admin;
        }

        @Data
        public static class Register {
            private String code;
            private String message;
        }
    }
}
