package com.board.api.voc.service;

import com.board.api.account.entity.Account;
import com.board.api.voc.entity.Voc;
import com.board.api.voc.enumerate.VocStatus;
import com.board.api.voc.form.VocForm.Response;
import com.board.api.voc.form.VocForm.Request;
import com.board.api.voc.repository.VocRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import static com.board.api.voc.mapper.VocMapper.mapper;

@Service
@RequiredArgsConstructor
public class VocService {

    private final VocRepository vocRepository;

    public Page<Response.VocList> getListByCustomerId(String id, Pageable pageable) {
        return vocRepository.findAllByCustomerId(id, pageable).map(mapper::toVocList);
    }

    public Page<Response.VocList> getList(Pageable pageable) {
        return vocRepository.findAllByVocStatusEquals(VocStatus.NO_MANAGER, pageable).map(mapper::toVocList);
    }

    public Voc getVoc(Long id) {
        return vocRepository.findOneById(id);
    }

    public Response.VocPage getPage(Long id) {
        return mapper.toVocPage(vocRepository.findOneById(id));
    }

    public Response.Register register(Request.Register register){
        Response.Register result = new Response.Register();
        try {
            vocRepository.save(mapper.toVoc(register));
            result.setCode("200");
            result.setMessage("등록 완료");
        }catch (Exception e) {
            result.setCode("500");
            result.setMessage("등록 실패 : " + e);
        }
        return result;
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public boolean changeStatus(Long vocId, Account account) {
        Voc voc = vocRepository.findOneById(vocId);
        if(voc.getVocStatus() == VocStatus.NO_MANAGER) {
            voc.setVocStatus(VocStatus.MANAGED);
        } else {
            voc.setVocStatus(VocStatus.COMPLETE);
        }
        voc.setUser(account);
        try {
            vocRepository.save(voc);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
