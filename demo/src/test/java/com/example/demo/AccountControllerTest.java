package com.example.demo;

import com.example.demo.entity.Account;
import com.example.demo.service.AccountService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
public class AccountControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AccountService accountService;

    @Test
    public void createAccounts() throws Exception{

        Account account = new Account();
        account.setNumber("456789");

        Mockito.when(accountService.saveAccount(any(Account.class))).thenReturn(account);


        /*mockMvc.perform(post("/api/v1/account")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"number\": \"John\", \"gender\": \"Male\" }"))*/

    }
}
