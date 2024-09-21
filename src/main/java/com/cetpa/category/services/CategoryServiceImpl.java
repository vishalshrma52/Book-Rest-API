package com.cetpa.category.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cetpa.models.BookCategory;
import com.cetpa.repositories.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService 
{
	@Autowired
	private CategoryRepository repo;

	public BookCategory createCategory(BookCategory category) 
	{
		BookCategory cat=repo.save(category);
		return cat;
	}
}
