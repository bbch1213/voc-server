package com.board.api.account.controller;

import com.board.api.account.form.AccountForm.Request;
import com.board.api.account.form.AccountForm.Response;
import com.board.api.account.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("${api.endpoint}")
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/login")
    public Response.Login loginUser(@RequestBody Request.Login loginForm) {
        return accountService.loginUser(loginForm);
    }
}
