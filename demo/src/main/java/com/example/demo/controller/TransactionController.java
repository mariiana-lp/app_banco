package com.example.demo.controller;

import com.example.demo.entity.Account;
import com.example.demo.entity.Transaction;
import com.example.demo.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.temporal.Temporal;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/transactions")
@CrossOrigin(origins = "http://localhost:4200/")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @GetMapping()
    public List<Transaction> getAllTransactions(){
        return transactionService.getAllTransactions();
    }

    @GetMapping("/{id}")
    public Transaction getTransactionById(@PathVariable("id") long id) {
        return transactionService.getTransactionById(id);
    }

    @PostMapping()
    public Transaction createTransaction(@RequestBody Transaction transaction) {
        return transactionService.saveTransaction(transaction);
    }

    @PutMapping("/{id}")
    public Transaction updateTransaction(@PathVariable long id, @RequestBody Transaction transactionDetails){
        Transaction transaction = transactionService.getTransactionById(id);
        transaction.setDate(transactionDetails.getDate());
        transaction.setType(transactionDetails.getType());
        transaction.setBalance(transactionDetails.getBalance());
        transaction.setAccount(transactionDetails.getAccount());
        transaction.setValue(transactionDetails.getValue());
        return transactionService.saveTransaction(transaction);
    }

    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable long id) {
        transactionService.deleteTransaction(id);
    }

}
