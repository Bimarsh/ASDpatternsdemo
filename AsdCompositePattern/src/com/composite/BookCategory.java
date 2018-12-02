package com.composite;

public abstract class BookCategory implements ProductCatalog {
	String name="BookCategory";
public abstract void addBook(BookCategory book);
}
