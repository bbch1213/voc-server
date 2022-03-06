package com.board.api.voc.controller;

import com.board.api.voc.adapter.VocAdapter;
import com.board.api.voc.form.VocForm.Request;
import com.board.api.voc.form.VocForm.Response;
import com.board.api.voc.service.VocService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("${api.endpoint}")
public class VocController {

    private final VocService vocService;
    private final VocAdapter vocAdapter;

    @GetMapping("/voc/findByCustomerId/{customerId}")
    public Page<Response.VocList> getList(@PathVariable String customerId, Pageable pageable)
    {
        return vocService.getListByCustomerId(customerId, pageable);
    }

    @GetMapping("/user/findAll")
    public Page<Response.VocList> getList(Pageable pageable)
    {
        return vocService.getList(pageable);
    }

    @GetMapping("/voc/findOne/{id}")
    public Response.VocPage getPage(@PathVariable Long id) {
        return vocService.getPage(id);
    }

    @PutMapping("/user/voc/{id}/select")
    public boolean selectVoc(@PathVariable Long id, HttpServletRequest request) {
        return vocAdapter.changeStatus(request, id);
    }

    @PostMapping("/voc/register")
    public Response.Register register(@Valid @RequestBody Request.Register voc)
    {
        return vocService.register(voc);
    }
}
