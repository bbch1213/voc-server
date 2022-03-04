package com.board.api.voc.form;

import com.board.api.voc.enumerate.VocStatus;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

public class VocForm {

    public static class Request {

        @Data
        public static class Voc {
            private String customerId;
        }

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
        public static class VocToCustomer {
            private long id;
            private String title;
            private VocStatus vocStatus;
            private LocalDateTime created_at;
        }

        @Data
        public static class VocToUser {
            private long id;
            private String customerId;
            private String title;
            private VocStatus vocStatus;
            private LocalDateTime created_at;
        }

        @Data
        public static class Register {
            private String code;
            private String message;
        }
    }
}
