package com.board.api.reply.service;

import com.board.api.reply.entity.Reply;
import com.board.api.reply.form.ReplyForm.Response;
import com.board.api.reply.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

import static com.board.api.reply.mapper.ReplyMapper.mapper;

@Service
@RequiredArgsConstructor
public class ReplyService {

    private final ReplyRepository replyRepository;

    public List<Response.ReplyPage> getReply(Long vocId) {
        return mapper.mapListToBase(replyRepository.findAllByVocId(vocId));
    }

    public Response.Register saveReply(Reply reply)
    {
        Response.Register result = new Response.Register();
        try {
            replyRepository.save(reply);
            result.setCode("200");
            result.setMessage("등록 완료");
        }catch (Exception e) {
            result.setCode("500");
            result.setMessage("등록 실패 : " + e);
        }

        return result;
    }

}
