package com.composite;

import java.util.ArrayList;
import java.util.List;

public class Action extends DvDCategory {
String name="ActionCategory";
	List<DvDCategory> listofDvd= new ArrayList<>();

	@Override
	public void addDVD(DvDCategory dvd) {
		listofDvd.add(dvd);
		
	}

}
