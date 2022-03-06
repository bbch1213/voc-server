package com.board.api.reply.adapter;

import com.board.api.account.entity.Account;
import com.board.api.account.service.AccountService;
import com.board.api.reply.entity.Reply;
import com.board.api.reply.form.ReplyForm.Response;
import com.board.api.reply.form.ReplyForm.Request;
import com.board.api.reply.service.ReplyService;
import com.board.api.voc.entity.Voc;
import com.board.api.voc.service.VocService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class ReplyAdapter {

    private final AccountService accountService;
    private final VocService vocService;
    private final ReplyService replyService;

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public Response.Register saveReply(Request.Register register) {
        Reply reply = new Reply();
        Account account = accountService.findUser(register.getUserId());
        Voc voc = vocService.getVoc(register.getVocId());
        vocService.changeStatus(register.getVocId(), account);
        reply.setUser(account);
        reply.setVoc(voc);
        reply.setTitle(register.getTitle());
        reply.setContent(register.getContent());
        return replyService.saveReply(reply);
    }
}
