package com.driver.controller;

import com.driver.models.Transaction;
import com.driver.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//Add required annotations

public class TransactionController {

    //Add required annotations
    @Autowired
    TransactionService transactionService;

    @PostMapping("/issueBook")
    public ResponseEntity issueBook(@RequestParam("cardId") int cardId, @RequestParam("bookId") int bookId) throws Exception{
        String externalTransactionId = transactionService.issueBook(cardId, bookId);
       return new ResponseEntity<>("transaction completed" + externalTransactionId, HttpStatus.ACCEPTED);
    }

    //Add required annotations
    @PostMapping("/returnBook")
    public ResponseEntity returnBook(@RequestParam("cardId") int cardId, @RequestParam("bookId") int bookId) throws Exception{
        Transaction externalTransaction = transactionService.returnBook(cardId, bookId);
        return new ResponseEntity<>("transaction completed" + externalTransaction.getTransactionId(), HttpStatus.ACCEPTED);
    }
}
