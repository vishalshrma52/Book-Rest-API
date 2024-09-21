package com.cetpa.category.services;

import org.springframework.stereotype.Service;

import com.cetpa.models.BookCategory;

@Service
public interface CategoryService 
{
	BookCategory createCategory(BookCategory category);
}
