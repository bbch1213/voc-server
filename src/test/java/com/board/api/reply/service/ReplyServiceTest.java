package com.board.api.reply.service;

import com.board.api.account.entity.Account;
import com.board.api.account.enumerate.AccountRole;
import com.board.api.reply.entity.Reply;
import com.board.api.reply.form.ReplyForm;
import com.board.api.reply.repository.ReplyRepository;
import com.board.api.role.entity.Role;
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
        List<Role> roleList = new ArrayList<>();
        Role role = new Role();
        role.setRoleType(AccountRole.ROLE_ADMIN);
        role.setId(1L);
        role.setDescription("관리자");
        roleList.add(role);

        Account account = new Account();
        account.setUserId("testA");
        account.setPassword("1234");
        account.setRoles(roleList);
        account.setName("Kim");

        Voc voc = new Voc();
        voc.setId(1L);
        voc.setTitle("test");
        voc.setContent("test");
        voc.setVocStatus(VocStatus.MANAGED);
        voc.setCreatedAt(LocalDateTime.now());

        Reply reply = new Reply();
        reply.setId(1L);
        reply.setTitle("test");
        reply.setContent("test");
        reply.setCreatedBy(account);
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
        List<Role> roleList = new ArrayList<>();
        Role role = new Role();
        role.setRoleType(AccountRole.ROLE_ADMIN);
        role.setId(1L);
        role.setDescription("관리자");
        roleList.add(role);

        Account account = new Account();
        account.setUserId("testA");
        account.setPassword("1234");
        account.setRoles(roleList);
        account.setName("Kim");

        Voc voc = new Voc();
        voc.setId(1L);
        voc.setTitle("test");
        voc.setContent("test");
        voc.setVocStatus(VocStatus.MANAGED);
        voc.setCreatedAt(LocalDateTime.now());

        Reply reply = new Reply();
        reply.setId(1L);
        reply.setTitle("test");
        reply.setContent("test");
        reply.setCreatedBy(account);
        reply.setVoc(voc);

        when(replyRepository.save(reply))
                .thenReturn(reply);

        ReplyForm.Response.Register test = replyService.saveReply(reply);

        assertNotNull(test);

    }
}