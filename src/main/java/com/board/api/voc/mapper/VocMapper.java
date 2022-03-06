package com.board.api.voc.mapper;

import com.board.api.voc.entity.Voc;
import com.board.api.voc.form.VocForm.Response;
import com.board.api.voc.form.VocForm.Request;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface VocMapper {

    VocMapper mapper = Mappers.getMapper(VocMapper.class);

    Voc toVoc(Request.Register register);

    Response.VocList toVocList(Voc voc);
    Response.VocPage toVocPage(Voc voc);
}
