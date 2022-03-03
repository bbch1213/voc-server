package com.board.api.voc.service;

import com.board.api.voc.entity.Voc;
import com.board.api.voc.form.VocForm.Response;
import com.board.api.voc.form.VocForm.Request;
import com.board.api.voc.repository.VocRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.board.api.voc.mapper.VocMapper.mapper;

@Service
@RequiredArgsConstructor
public class VocService {

    private final VocRepository vocRepository;

    public Page<Response.VocToCustomer> getListByCustomerId(String id, Pageable pageable) {
        return vocRepository.findAllByCustomerId(id, pageable).map(mapper::toVocToCustomer);
    }

    public Page<Response.VocToUser> getList(Pageable pageable) {
        return vocRepository.findAll(pageable).map(mapper::toVocToUser);
    }

    public Response.Register register(Request.Register register){
        Voc voc = new Voc();
        Response.Register result = new Response.Register();
        voc.setTitle(register.getTitle());
        voc.setContent(register.getContent());
        voc.setCustomerId(register.getCustomerId());
        voc.setCreatedAt(LocalDateTime.now());
        try {
            vocRepository.save(voc);
            result.setCode("200");
            result.setMessage("등록 완료");
        }catch (Exception e) {
            result.setCode("500");
            result.setMessage("등록 실패 : " + e);
        }
        return result;
    }
}
