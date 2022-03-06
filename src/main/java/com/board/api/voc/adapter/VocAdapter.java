package com.board.api.voc.adapter;

import com.board.api.account.entity.Account;
import com.board.api.account.service.AccountService;
import com.board.api.common.helper.jwt.JwtTokenProvider;
import com.board.api.voc.service.VocService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;

@Component
@RequiredArgsConstructor
public class VocAdapter {

    private final JwtTokenProvider jwtTokenProvider;
    private final AccountService accountService;
    private final VocService vocService;

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public boolean changeStatus(HttpServletRequest request, Long vocId) {
        String token = jwtTokenProvider.resolveToken(request);
        Account account = accountService.findUser(jwtTokenProvider.getUserId(token));
        return vocService.changeStatus(vocId, account);
    }
}
