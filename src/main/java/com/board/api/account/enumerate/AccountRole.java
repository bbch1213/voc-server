package com.board.api.account.enumerate;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AccountRole {

    ROLE_USER("user"),
    ROLE_ANONYMOUS("anonymous");

    private String description;
}
