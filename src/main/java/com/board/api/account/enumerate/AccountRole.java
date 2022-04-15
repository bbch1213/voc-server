package com.board.api.account.enumerate;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AccountRole {

    ROLE_ADMIN("ADMIN"),
    ROLE_USER("USER"),
    ROLE_ANONYMOUS("ANONYMOUS");

    private String description;
}
