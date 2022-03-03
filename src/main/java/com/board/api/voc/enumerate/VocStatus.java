package com.board.api.voc.enumerate;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum VocStatus {

    NO_MANAGER("담당자 정해지지 않음."),
    MANAGED("담당자 정해짐."),
    COMPLETE("답변 완료");

    private String description;
}
