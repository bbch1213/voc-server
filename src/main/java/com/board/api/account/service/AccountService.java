package com.board.api.account.service;

import com.board.api.account.entity.Account;
import com.board.api.account.enumerate.AccountRole;
import com.board.api.account.form.AccountForm;
import com.board.api.account.form.AccountForm.Request;
import com.board.api.account.form.AccountForm.Response;
import com.board.api.account.repository.AccountRepository;
import com.board.api.common.helper.exception.AuthenticationException;
import com.board.api.common.helper.exception.LoginException;
import com.board.api.common.helper.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    public Response.Login loginUser(Request.Login loginForm) throws LoginException {
        Account account = accountRepository.findByUserId(loginForm.getUserId()).orElseThrow(LoginException::new);
        Response.Login loginResult = new Response.Login();
        if(!passwordEncoder.matches(loginForm.getPassword(), account.getPassword())) {
            throw new LoginException();
        } else {
            loginResult.setToken(jwtTokenProvider.createToken(account.getUserId(), account.getRole()));
        }

        return loginResult;
    }
}
