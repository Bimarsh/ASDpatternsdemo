package com.composite;

import java.util.ArrayList;
import java.util.List;

public class ComputerBookCategory extends BookCategory {
String name="ComputerBookCategory";
	List<BookCategory> bookCategory= new ArrayList<>();
	@Override
	public void addBook(BookCategory book) {
		// TODO Auto-generated method stub
		
		bookCategory.add(book);
		
	}

}
