package com.cetpa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cetpa.category.services.CategoryService;
import com.cetpa.models.BookCategory;

@RestController
@RequestMapping("category")
public class CategoryController
{
	@Autowired
	private CategoryService service;
	
	@PostMapping("create")
	public ResponseEntity<BookCategory> createCategory(@RequestBody BookCategory category)
	{
		BookCategory cat=service.createCategory(category);
		return ResponseEntity.status(HttpStatus.CREATED).body(cat);
	}
}
