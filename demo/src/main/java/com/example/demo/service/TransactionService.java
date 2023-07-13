package com.example.demo.service;

import com.example.demo.entity.Account;
import com.example.demo.entity.Transaction;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionsRepository transactionsRepository;

    @Autowired
    private AccountRepository accountRepository;

    public List<Transaction> getAllTransactions(){
        return transactionsRepository.findAll();
    }

    public Transaction getTransactionById(long id){
        return transactionsRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Movimiento no encontrado con ID: " + id));
    }

    public Transaction saveTransaction(Transaction transaction){
        Account account = accountRepository.findById((transaction.getAccount().getIdAccount()))
                .orElseThrow(()-> new IllegalArgumentException("Cuenta no encontrada"));
        transaction.setAccount(account);

        int currentBalance = account.getBalance();
        int newBalance = currentBalance;

        if(transaction.getType().equals("debit")){
            if(transaction.getValue()<= currentBalance){
                newBalance = currentBalance - transaction.getValue();
            }else {
                new IllegalArgumentException("Saldo insuficiente");
            }
        }else if(transaction.getType().equals("credit")){
            newBalance = currentBalance + transaction.getValue();
        }
        account.setBalance(newBalance);
        transaction.setBalance(newBalance);
        accountRepository.save(account);
        return transactionsRepository.save(transaction);
    }

    /*public void generateReport(String Date, long idClient ) {
        // Lógica para generar el informe y obtener los resultados en formato base64 (PDF) y JSON
        // ...
    }*/


    public void deleteTransaction(long id){
        transactionsRepository.deleteById(id);
    }

}
