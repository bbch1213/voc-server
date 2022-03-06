package com.board.api.reply.repository;

import com.board.api.reply.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReplyRepository extends JpaRepository<Reply, Long> {

    List<Reply> findAllByVocId(Long vocId);
}
