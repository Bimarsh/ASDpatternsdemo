package com.account;

public class Checking2pt5Algorithm implements InterestBehavior {

	@Override
	public double calculateInterests(double amount) {
		// TODO Auto-generated method stub
		return amount+(2.5/100*amount);
	}

}
