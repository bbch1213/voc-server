package com.board.api.account.mapper;

import com.board.api.account.entity.Account;
import com.board.api.account.form.AccountForm.Request;
import com.board.api.account.form.AccountForm.Response;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AccountMapper {

    AccountMapper mapper = Mappers.getMapper(AccountMapper.class);

    Account toAccount(Response.Login login);
}
