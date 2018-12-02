package com.account;

public class Saving1percentAlgorithm implements InterestBehavior {

	@Override
	public double calculateInterests(double amount) {
		// TODO Auto-generated method stub
		return amount+(1/100*amount);
	}

}
