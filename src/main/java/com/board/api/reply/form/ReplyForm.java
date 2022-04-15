package com.board.api.reply.form;

import com.board.api.common.base.BaseForm;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

public class ReplyForm {

    public static class Request {

        @Data
        @Getter
        @Setter
        public static class Register {
            private String userId;
            private Long vocId;
            private String title;
            private String content;
        }

    }

    public static class Response {

        @Data
        public static class ReplyPage {
            private BaseForm.Response.Account createdBy;
            private String title;
            private String content;
            private LocalDateTime createdAt;
        }

        @Data
        public static class Register {
            private String code;
            private String message;
        }
    }
}
