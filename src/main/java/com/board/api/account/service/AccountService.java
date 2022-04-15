package com.board.api.account.service;

import com.board.api.account.entity.Account;
import com.board.api.account.form.AccountForm.Request;
import com.board.api.account.form.AccountForm.Response;
import com.board.api.account.repository.AccountRepository;
import com.board.api.common.helper.exception.LoginException;
import com.board.api.common.helper.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.h2.security.auth.AuthenticationException;
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
            throw new LoginException(loginForm.getUserId());
        } else {
            loginResult.setToken(jwtTokenProvider.createToken(account.getUserId(), account.getRoles()));
            loginResult.setUserId(account.getUserId());
            loginResult.setRole(account.getRoles());
        }

        return loginResult;
    }

    public Account findOneById(Long id) throws AuthenticationException {
        return accountRepository.findById(id).orElseThrow(AuthenticationException::new);
    }

    public Account findUser(String id) {
        return accountRepository.findByUserId(id).orElseThrow(LoginException::new);
    }
}
