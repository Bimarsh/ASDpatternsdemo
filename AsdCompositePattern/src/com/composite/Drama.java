package com.composite;

import java.util.ArrayList;
import java.util.List;

public class Drama extends DvDCategory {
	
	String name="DramaCategory";
List<DvDCategory> listofDvd= new ArrayList<>();

@Override
public void addDVD(DvDCategory dvd) {
	listofDvd.add(dvd);
	
}

}
