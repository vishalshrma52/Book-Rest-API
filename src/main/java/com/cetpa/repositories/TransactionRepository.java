package com.cetpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cetpa.models.BookTransaction;

public interface TransactionRepository extends JpaRepository<BookTransaction, Integer>
{

}