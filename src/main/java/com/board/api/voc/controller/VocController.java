package com.board.api.voc.controller;

import com.board.api.voc.adapter.VocAdapter;
import com.board.api.voc.form.VocForm.Request;
import com.board.api.voc.form.VocForm.Response;
import com.board.api.voc.service.VocService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("${api.endpoint}")
public class VocController {

    private final VocService vocService;
    private final VocAdapter vocAdapter;

    @GetMapping("/voc/customers/{customerId}")
    public Page<Response.VocList> getList(@PathVariable String customerId, Pageable pageable)
    {
        return vocService.getListByCustomerId(customerId, pageable);
    }

    @GetMapping("/voc/pages")
    public Page<Response.VocList> getList(Pageable pageable)
    {
        return vocService.getList(pageable);
    }

    @GetMapping("/user/voc/no-managed")
    public Page<Response.VocList> getListNoManaged(Pageable pageable) {
        return vocService.getListNoManaged(pageable);
    }

    @GetMapping("/voc/{id}")
    public Response.VocPage getPage(@PathVariable Long id) {
        return vocService.getPage(id);
    }

    @PutMapping("/user/voc/{id}")
    public boolean selectVoc(@PathVariable Long id) {
        return vocAdapter.changeStatus(id);
    }

    @PostMapping("/voc/add")
    public Response.Register register(@Valid @RequestBody Request.Register voc)
    {
        return vocService.register(voc);
    }
}
