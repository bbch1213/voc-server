package com.board.api.voc.mapper;

import com.board.api.voc.entity.Voc;
import com.board.api.voc.form.VocForm.Response;
import com.board.api.voc.form.VocForm.Request;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface VocMapper {

    VocMapper mapper = Mappers.getMapper(VocMapper.class);

    Voc toVoc(Response.VocToCustomer voc);
    Voc toVoc(Response.VocToUser voc);

    Response.VocToCustomer toVocToCustomer(Voc voc);
    Response.VocToUser toVocToUser(Voc voc);
}
