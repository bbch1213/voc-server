package com.board.api.common.config;

import com.board.api.account.entity.Account;
import com.board.api.common.helper.PrincipalHelper;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Auditor implements AuditorAware<Account> {

    @Override
    public Optional<Account> getCurrentAuditor() {
        Account account = PrincipalHelper.getAccount();
        return ObjectUtils.allNotNull(account) ? Optional.of(account) : Optional.empty();
    }
}
