package com.board.api.reply.mapper;

import com.board.api.reply.entity.Reply;
import com.board.api.reply.form.ReplyForm.Request;
import com.board.api.reply.form.ReplyForm.Response;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ReplyMapper {

    ReplyMapper mapper = Mappers.getMapper(ReplyMapper.class);

    @Named("toReplyPage")
    Response.ReplyPage toReplyPage(Reply reply);

    Reply toReply(Request.Register register);

    @IterableMapping(qualifiedByName = "toReplyPage")
    @Named("MapListToReply")
    List<Response.ReplyPage> mapListToBase(List<Reply> replies);
}
