package com.board.api.voc.repository;

import com.board.api.voc.entity.Voc;
import com.board.api.voc.enumerate.VocStatus;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface VocRepository extends JpaRepository<Voc, Long>, QuerydslPredicateExecutor<Voc> {

    Page<Voc> findAll(Predicate predicate, Pageable pageable);

    Voc findOneById(Long id);

    Page<Voc> findAllByVocStatusEquals(VocStatus vocStatus, Pageable pageable);
}
