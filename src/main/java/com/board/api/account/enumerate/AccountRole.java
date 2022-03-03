package com.board.api.account.enumerate;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AccountRole {

    HAS_USER("user"),
    HAS_ANONYMOUS("anonymous");

    private String description;
}
