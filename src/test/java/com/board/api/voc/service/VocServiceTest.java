package com.board.api.voc.service;

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

    @Test
    void getVoc() {
        Voc voc = new Voc();
        voc.setId(1L);
        voc.setCustomerId("test");
        voc.setTitle("test");
        voc.setContent("test");
        voc.setVocStatus(VocStatus.NO_MANAGER);
        voc.setCreatedAt(LocalDateTime.now());

        when(vocRepository.findOneById(1L))
                .thenReturn(voc);

        VocForm.Response.VocPage test = vocService.getPage(1L);

        assertNotNull(test);
    }

    @Test
    void register() {
        Voc voc = new Voc();
        voc.setId(1L);
        voc.setCustomerId("test");
        voc.setTitle("test");
        voc.setContent("test");
        voc.setVocStatus(VocStatus.NO_MANAGER);
        voc.setCreatedAt(LocalDateTime.now());

        VocForm.Request.Register register = new VocForm.Request.Register();
        register.setTitle("test");
        register.setContent("test");
        register.setCustomerId("test");
        when(vocRepository.save(voc))
                .thenReturn(voc);

        VocForm.Response.Register test = vocService.register(register);

        assertNotNull(test);
    }
}