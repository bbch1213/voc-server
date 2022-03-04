package com.board.api.voc.controller;

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

    @GetMapping("/findByCustomerId/{customerId}")
    public Page<Response.VocToCustomer> getList(@PathVariable String customerId, Pageable pageable)
    {
        return vocService.getListByCustomerId(customerId, pageable);
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
