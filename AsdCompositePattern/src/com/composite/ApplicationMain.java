package com.composite;

public class ApplicationMain {

	public static void main(String[] args) {
	BookCategory asd= new Book("111", "ASAD");
	BookCategory ficton= new Book("12", "spacetime");
	BookCategory ficcategory= new FictionCategory();
	ficcategory.addBook(ficton);
	BookCategory computerbookCategory= new ComputerBookCategory();
	computerbookCategory.addBook(asd);
	
	
	DvDCategory dramadvd= new Dvd("dramaqueen");
	DvDCategory actiodvd= new Dvd("mi5");
	DvDCategory drama= new Drama();
	drama.addDVD(dramadvd);
	DvDCategory action = new Action();
	action.addDVD(actiodvd);
	
	
	

	}

}
