package com.cetpa.models;

import javax.persistence.*;

@Entity

public class BookTransaction 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tid;
	@ManyToOne
	private Book book;
	private int quantity;
	private String date;
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
}
