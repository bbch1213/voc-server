package com.board.api.voc.controller;

import com.board.api.voc.entity.Voc;
import com.board.api.voc.form.VocForm.Request;
import com.board.api.voc.form.VocForm.Response;
import com.board.api.voc.service.VocService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("${api.endpoint}/voc")
public class VocController {

    private final VocService vocService;

    @GetMapping("/findByCustomerId")
    public Page<Response.VocToCustomer> getList(@RequestBody Request.Voc voc, Pageable pageable)
    {
        return vocService.getListByCustomerId(voc.getCustomerId(), pageable);
    }

    @GetMapping("/findAll")
    public Page<Response.VocToUser> getList(Pageable pageable)
    {
        return vocService.getList(pageable);
    }

    @PostMapping("/register")
    public Response.Register register(@RequestBody Request.Register voc)
    {
        return vocService.register(voc);
    }
}
