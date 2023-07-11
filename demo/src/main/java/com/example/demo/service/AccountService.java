package com.example.demo.service;

import com.example.demo.entity.Account;
import com.example.demo.entity.Client;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ClientRepository clientRepository;

    public List<Account> getAllAccounts(){
        return accountRepository.findAll();
    }

    public Account getAccountById(long id){
        return accountRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Cuenta no encontrado con ID: " + id));
    }

    public Account saveAccount (Account account){
        Client client = clientRepository.findById(account.getClient().getIdPerson())
                .orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado"));

        account.setClient(client);
        return accountRepository.save(account);
    }

    public void deleteAccount(long id){
        accountRepository.deleteById(id);
    }
}
