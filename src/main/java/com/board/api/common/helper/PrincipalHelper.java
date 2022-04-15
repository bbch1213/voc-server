package com.board.api.common.helper;

import com.board.api.account.entity.Account;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class PrincipalHelper {

    public static Authentication getAuthentication() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(Objects.isNull(authentication)) {
            return null;
        }
        return authentication;
    }

    public static Account getAccount() {
        if(Objects.isNull(getAuthentication())) {
            return null;
        }
        Account account = (Account) getAuthentication().getPrincipal();
        return account;
    }

    public static Long getId() {
        if(Objects.isNull(getAuthentication())) {
            return null;
        }
        return getAccount().getId();
    }
}
