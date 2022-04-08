package com.board.api.voc.adapter;

import com.board.api.account.entity.Account;
import com.board.api.account.service.AccountService;
import com.board.api.common.helper.PrincipalHelper;
import com.board.api.common.helper.jwt.JwtTokenProvider;
import com.board.api.voc.entity.Voc;
import com.board.api.voc.form.VocForm;
import com.board.api.voc.service.VocService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;

import static com.board.api.voc.mapper.VocMapper.mapper;

@Component
@RequiredArgsConstructor
public class VocAdapter {

    private final JwtTokenProvider jwtTokenProvider;
    private final AccountService accountService;
    private final VocService vocService;

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public boolean changeStatus(Long vocId) {
        Account account = (Account) PrincipalHelper.getAuthentication().getPrincipal();
        return vocService.changeStatus(vocId, account);
    }

    @Transactional
    public VocForm.Response.Register register(VocForm.Request.Register register){
        VocForm.Response.Register result = new VocForm.Response.Register();
        try {
            Voc data = mapper.toVoc(register);
            data.setUser(accountService.findOneById(PrincipalHelper.getId()));
            vocService.save(data);
            result.setCode("200");
            result.setMessage("등록 완료");
        }catch (Exception e) {
            result.setCode("500");
            result.setMessage("등록 실패 : " + e);
        }
        return result;
    }
}
