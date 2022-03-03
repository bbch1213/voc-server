package com.board.api.Account.controller;

import com.board.api.account.form.AccountForm.Request;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


@SpringBootTest
@AutoConfigureMockMvc
class AccountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void loginTest() throws Exception {
        Request.Login loginForm = new Request.Login();
        loginForm.setUserId("testA");
        loginForm.setPassword("1234");

        String content = objectMapper.writeValueAsString(loginForm);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/login").content(content))
                .andExpect(mvcResult -> {
                    MockHttpServletResponse response = mvcResult.getResponse();
                    System.out.println(response.getContentAsString());
                });
    }

}