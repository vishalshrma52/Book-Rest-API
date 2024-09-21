package com.cetpa.models;

import javax.persistence.*;

@Entity
public class Book 
{
	@Id
	@GeneratedValue(generator = "book_seq")
	@SequenceGenerator(name = "book_seq",initialValue = 11111,allocationSize = 1)
	private int bookid;
	private String title;
	private String author;
	@ManyToOne
	private BookCategory category;
	private int copies;
	private int price;
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public BookCategory getCategory() {
		return category;
	}
	public void setCategory(BookCategory category) {
		this.category = category;
	}
	public int getCopies() {
		return copies;
	}
	public void setCopies(int copies) {
		this.copies = copies;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
}
