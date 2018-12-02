package com.composite;

public class Book extends BookCategory {
	
	String isbn;
	String title;
	public Book(String isbn, String title) {
		super();
		this.isbn = isbn;
		this.title = title;
	}
	@Override
	public void addBook(BookCategory book) {
		// TODO Auto-generated method stub
		
	}

}
