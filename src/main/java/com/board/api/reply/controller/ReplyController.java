package com.board.api.reply.controller;

import com.board.api.reply.adapter.ReplyAdapter;
import com.board.api.reply.form.ReplyForm.Request;
import com.board.api.reply.form.ReplyForm.Response;
import com.board.api.reply.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("${api.endpoint}")
public class ReplyController {

    private final ReplyService replyService;
    private final ReplyAdapter replyAdapter;

    @GetMapping("/voc/{vocId}/reply")
    public List<Response.ReplyPage> getPage(@PathVariable Long vocId) {
        return replyService.getReply(vocId);
    }

    @PostMapping("/reply/register")
    public Response.Register savePage(@Valid @RequestBody Request.Register register) {
        return replyAdapter.saveReply(register);
    }
}
