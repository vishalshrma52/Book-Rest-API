package com.cetpa.controllers;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cetpa.book.services.BookService;
import com.cetpa.models.BookTransaction;
import com.cetpa.repositories.BookRepository;
import com.cetpa.repositories.TransactionRepository;

@RestController
@RequestMapping("transaction")
public class TransactionController 
{
   @Autowired
   private TransactionRepository trepo;
   @Autowired
   private BookRepository brepo;
   
   @PostMapping("create")
   public ResponseEntity<BookTransaction> createTransaction(@RequestBody BookTransaction bt)
   {
	   bt.setDate(LocalDate.now().toString());
	   BookTransaction tt=trepo.save(bt);
	   //brepo.decreaseCopies(bt.getQuantity(), bt.getQuantity().getBookid());
	   return ResponseEntity.status(HttpStatus.CREATED).body(tt);
   }
}
