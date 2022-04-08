package com.board.api.voc.service;

import com.board.api.account.entity.Account;
import com.board.api.common.helper.PrincipalHelper;
import com.board.api.voc.entity.Voc;
import com.board.api.voc.enumerate.VocStatus;
import com.board.api.voc.form.VocForm.Response;
import com.board.api.voc.form.VocForm.Request;
import com.board.api.voc.predicate.VocPredicate;
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

    public Page<Response.VocList> getListByUsername(String id, Pageable pageable) {
        return vocRepository.findAll(VocPredicate.searchToUserId(id), pageable).map(mapper::toVocList);
    }

    public Page<Response.VocList> getList(Pageable pageable) {
        return vocRepository.findAll(pageable).map(mapper::toVocList);
    }

    public Page<Response.VocList> getListNoManaged(Pageable pageable) {
        return vocRepository.findAllByVocStatusEquals(VocStatus.NO_MANAGER, pageable).map(mapper::toVocList);
    }

    public Voc getVoc(Long id) {
        return vocRepository.findOneById(id);
    }

    public Response.VocPage getPage(Long id) {
        return mapper.toVocPage(vocRepository.findOneById(id));
    }

    public void save(Voc voc) {
        vocRepository.save(voc);
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
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
