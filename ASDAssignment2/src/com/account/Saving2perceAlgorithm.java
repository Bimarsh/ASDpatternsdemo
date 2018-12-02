package com.account;

public class Saving2perceAlgorithm implements InterestBehavior {

	@Override
	public double calculateInterests(double amount) {
		// TODO Auto-generated method stub
		return amount+(2/100*amount);
	}

}
