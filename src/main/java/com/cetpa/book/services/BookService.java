package com.cetpa.book.services;

import java.util.List;

import com.cetpa.models.Book;

public interface BookService 
{
	Book createBook(Book book);
	List<Book> getBookList();
	Book getById(int bid);
	List<Book> getBookByAuthor(String author);
	List<Book> getBookByPriceRange(int p1, int p2);
	//List<Book> getBookByCatId(int cid);
	List<Book> getBookByCategory(String cat);
	int increaseCopies(int cpy, int bid);
	int decreaseCopies(int cpy, int bid);
}
