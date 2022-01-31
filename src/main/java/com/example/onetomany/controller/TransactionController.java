package com.example.onetomany.controller;

import com.example.onetomany.service.TestTransactions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    @Autowired
    private TestTransactions testTransactions;

    @GetMapping
    public void testTransactions(){
        testTransactions.testingTransactions();
    }
}
