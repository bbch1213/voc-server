package com.board.api.voc.service;

import com.board.api.account.entity.Account;
import com.board.api.account.enumerate.AccountRole;
import com.board.api.role.entity.Role;
import com.board.api.voc.adapter.VocAdapter;
import com.board.api.voc.entity.Voc;
import com.board.api.voc.enumerate.VocStatus;
import com.board.api.voc.form.VocForm;
import com.board.api.voc.repository.VocRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.board.api.voc.mapper.VocMapper.mapper;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@ActiveProfiles("test")
class VocServiceTest {

    @Mock
    VocRepository vocRepository;

    @InjectMocks
    VocService vocService;

    @InjectMocks
    VocAdapter vocAdapter;

    @Test
    void getVoc() {
        List<Role> roleList1 = new ArrayList<>();
        Role role1 = new Role();
        role1.setRoleType(AccountRole.ROLE_ADMIN);
        role1.setId(1L);
        role1.setDescription("관리자");
        roleList1.add(role1);

        List<Role> roleList2 = new ArrayList<>();
        Role role2 = new Role();
        role2.setRoleType(AccountRole.ROLE_USER);
        role2.setId(2L);
        role2.setDescription("사용자");
        roleList2.add(role2);

        Account admin = new Account();
        admin.setId(1L);
        admin.setUserId("testA");
        admin.setPassword("1234");
        admin.setRoles(roleList1);
        admin.setName("Kim");

        Account user = new Account();
        user.setId(2L);
        user.setUserId("customerA");
        user.setPassword("1234");
        user.setRoles(roleList2);
        user.setName("Kang");

        Voc voc = new Voc();
        voc.setId(1L);
        voc.setAdmin(admin);
        voc.setTitle("test");
        voc.setContent("test");
        voc.setVocStatus(VocStatus.NO_MANAGER);
        voc.setCreatedAt(LocalDateTime.now());
        voc.setCreatedBy(user);

        when(vocRepository.findOneById(1L))
                .thenReturn(voc);

        VocForm.Response.VocPage test = vocService.getPage(1L);

        assertNotNull(test);
    }

    @Test
    void register() {
        List<Role> roleList = new ArrayList<>();
        Role role = new Role();
        role.setRoleType(AccountRole.ROLE_USER);
        role.setId(1L);
        role.setDescription("사용자");
        roleList.add(role);

        Account user = new Account();
        user.setId(1L);
        user.setUserId("customerA");
        user.setPassword("1234");
        user.setRoles(roleList);
        user.setName("Kang");

        Voc voc = new Voc();
        voc.setId(1L);
        voc.setTitle("test");
        voc.setContent("test");
        voc.setVocStatus(VocStatus.NO_MANAGER);
        voc.setCreatedBy(user);
        voc.setCreatedAt(LocalDateTime.now());

        VocForm.Request.Register register = new VocForm.Request.Register();
        register.setTitle("test");
        register.setContent("test");
        when(vocRepository.save(voc))
                .thenReturn(voc);

        VocForm.Response.Register test = vocAdapter.register(register);

        assertNotNull(test);
    }
}