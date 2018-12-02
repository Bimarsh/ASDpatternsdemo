package com.composite;

import java.util.ArrayList;
import java.util.List;

public class FictionCategory extends BookCategory {
String name="fictionCategory";
	List<BookCategory> bookCategory= new ArrayList<>();
	@Override
	public void addBook(BookCategory book) {
		// TODO Auto-generated method stub
		
		bookCategory.add(book);
		
	}

}
