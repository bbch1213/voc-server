package com.board.api.Account.service;

import com.board.api.account.entity.Account;
import com.board.api.account.enumerate.AccountRole;
import com.board.api.account.repository.AccountRepository;
import com.board.api.account.service.AccountService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@ActiveProfiles("test")
class AccountServiceTest {

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private AccountService accountService;

    @Test
    void findUser() {
        Account account = new Account();
        account.setUserId("testA");
        account.setPassword("1234");
        account.setRole(AccountRole.HAS_USER);
        account.setName("Kim");

        when(accountRepository.findByUserId("testA"))
                .thenReturn(Optional.of(account));

        Account test = accountService.findUser("testA");

        assertNotNull(test);
    }
}