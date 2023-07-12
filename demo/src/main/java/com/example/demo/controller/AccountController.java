package com.example.demo.controller;

import com.example.demo.entity.Account;
import com.example.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping()
    public List<Account> getAllAcounts(){
       return accountService.getAllAccounts();
    }

    @GetMapping("/{id}")
    public Account getAccountById(@PathVariable("id") long id) {
        return accountService.getAccountById(id);
    }

    @PostMapping()
    public Account createAccount(@RequestBody Account account) {
        return accountService.saveAccount(account);
    }

    @PutMapping("/{id}")
    public Account updateAccount(@PathVariable long id, @RequestBody Account accountDetails){
        Account account = accountService.getAccountById(id);
        account.setNumber(accountDetails.getNumber());
        account.setType(accountDetails.getType());
        account.setBalance(accountDetails.getBalance());
        account.setStatus(accountDetails.isStatus());
        account.setClient(accountDetails.getClient());

        return accountService.saveAccount(account);
    }

    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable long id) {
        accountService.deleteAccount(id);
    }



}
