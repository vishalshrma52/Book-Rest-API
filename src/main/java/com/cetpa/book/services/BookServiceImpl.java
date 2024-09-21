package com.cetpa.book.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cetpa.models.Book;
import com.cetpa.repositories.BookRepository;
import com.cetpa.repositories.CategoryRepository;

@Service
public class BookServiceImpl implements BookService 
{
	@Autowired
	private BookRepository repo;
	@Autowired
	private CategoryRepository crepo;

	public Book createBook(Book book) 
	{
		return repo.save(book);
	}
	public List<Book> getBookList() 
	{
		return repo.findAll();
	}
	public Book getById(int bid) 
	{
		return repo.findById(bid).orElse(null);
	}
	public List<Book> getBookByAuthor(String author) 
	{
		return repo.findByAuthor(author);
	}
	public List<Book> getBookByPriceRange(int p1, int p2) 
	{
		return repo.findByPriceRange(p1, p2);
	}
	/*public List<Book> getBookByCatId(int cid) 
	{
		return repo.findByCatId(crepo.findById(cid).orElse(null));
	}*/
	public List<Book> getBookByCategory(String cat) 
	{
		return repo.findByCategory(cat);
	}
	public int increaseCopies(int cpy, int bid) 
	{
		return repo.increaseCopies(cpy, bid);
	}
	@Override
	public int decreaseCopies(int cpy, int bid) 
	{
		return repo.decreaseCopies(cpy, bid);
	}
}
