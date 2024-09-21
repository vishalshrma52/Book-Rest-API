package com.cetpa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cetpa.book.services.BookService;
import com.cetpa.models.Book;

@RestController
@RequestMapping("book")
public class BookController 
{
	@Autowired
	private BookService service;
	
	@PostMapping("create")
	public ResponseEntity<Book> createBookResource(@RequestBody Book book)
	{
		Book b=service.createBook(book);
		return ResponseEntity.status(HttpStatus.CREATED).body(b);
	}
	@GetMapping("list")
	public ResponseEntity<List<Book>> getAllBooks()
	{
		List<Book> list=service.getBookList();
		if(list.isEmpty())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		return ResponseEntity.status(HttpStatus.CREATED).body(list);
	}
	@GetMapping("byid/{bid}")
	public ResponseEntity<Book> getBookById(@PathVariable int bid)
	{
		Book book=service.getById(bid);
		if(book==null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.status(HttpStatus.CREATED).body(book);
	}
	@GetMapping("byauthor/{author}")
	public ResponseEntity<List<Book>> getBookByAuthor(@PathVariable String author)
	{
		List<Book> list=service.getBookByAuthor(author);
		if(list.isEmpty())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		return ResponseEntity.status(HttpStatus.CREATED).body(list);
	}
	@GetMapping("pricerange/{p1}/{p2}")
	public ResponseEntity<List<Book>> getBookByPriceRange(@PathVariable int p1, @PathVariable int p2)
	{
		List<Book> list=service.getBookByPriceRange(p1,p2);
		if(list.isEmpty())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		return ResponseEntity.status(HttpStatus.CREATED).body(list);
	}
	/*@GetMapping("bycatid/{cid}")
	public ResponseEntity<List<Book>> getBookByCatID(@PathVariable int cid)
	{
		List<Book> list=service.getBookByCatId(cid);
		if(list.isEmpty())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		return ResponseEntity.status(HttpStatus.CREATED).body(list);
	}*/
	@GetMapping("bycategory/{cat}")
	public ResponseEntity<List<Book>> getBookByCategory(@PathVariable String cat)
	{
		List<Book> list=service.getBookByCategory(cat);
		if(list.isEmpty())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		return ResponseEntity.status(HttpStatus.CREATED).body(list);
	}
	@PatchMapping("increasecpy/{cpy}/{bid}")
	public ResponseEntity <Book> increaseCopies(@PathVariable int cpy,@PathVariable int bid)
	{
		int n=service.increaseCopies(cpy,bid);
		if(n==0)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.status(HttpStatus.OK).build();		
	}
	@PatchMapping("decreasecpy/{cpy}/{bid}")
	public ResponseEntity <Book> decreaseCopies(@PathVariable int cpy,@PathVariable int bid)
	{
		int n=service.decreaseCopies(cpy,bid);
		if(n==0)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.status(HttpStatus.OK).build();		
	}
}
