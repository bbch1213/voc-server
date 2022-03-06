package com.board.api.reply.service;

import com.board.api.account.entity.Account;
import com.board.api.account.enumerate.AccountRole;
import com.board.api.reply.entity.Reply;
import com.board.api.reply.form.ReplyForm;
import com.board.api.reply.repository.ReplyRepository;
import com.board.api.voc.entity.Voc;
import com.board.api.voc.enumerate.VocStatus;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@ActiveProfiles("test")
class ReplyServiceTest {

    @Mock
    private ReplyRepository replyRepository;

    @InjectMocks
    private ReplyService replyService;

    @Test
    void getReply() {
        Account account = new Account();
        account.setUserId("testA");
        account.setPassword("1234");
        account.setRole(AccountRole.HAS_USER);
        account.setName("Kim");

        Voc voc = new Voc();
        voc.setId(1L);
        voc.setCustomerId("test");
        voc.setTitle("test");
        voc.setContent("test");
        voc.setVocStatus(VocStatus.MANAGED);
        voc.setCreatedAt(LocalDateTime.now());

        Reply reply = new Reply();
        reply.setId(1L);
        reply.setTitle("test");
        reply.setContent("test");
        reply.setUser(account);
        reply.setVoc(voc);

        List<Reply> list = new ArrayList<>();
        list.add(reply);

        when(replyRepository.findAllByVocId(voc.getId()))
                .thenReturn(list);

        List<ReplyForm.Response.ReplyPage> test = replyService.getReply(voc.getId());

        assertNotNull(test);
    }

    @Test
    void saveReply() {
        Account account = new Account();
        account.setUserId("testA");
        account.setPassword("1234");
        account.setRole(AccountRole.HAS_USER);
        account.setName("Kim");

        Voc voc = new Voc();
        voc.setId(1L);
        voc.setCustomerId("test");
        voc.setTitle("test");
        voc.setContent("test");
        voc.setVocStatus(VocStatus.MANAGED);
        voc.setCreatedAt(LocalDateTime.now());

        Reply reply = new Reply();
        reply.setId(1L);
        reply.setTitle("test");
        reply.setContent("test");
        reply.setUser(account);
        reply.setVoc(voc);

        when(replyRepository.save(reply))
                .thenReturn(reply);

        ReplyForm.Response.Register test = replyService.saveReply(reply);

        assertNotNull(test);

    }
}