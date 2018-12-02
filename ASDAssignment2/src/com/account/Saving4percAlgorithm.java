package com.account;

public class Saving4percAlgorithm implements InterestBehavior{

	@Override
	public double calculateInterests(double amount) {
		// TODO Auto-generated method stub
		return amount+(4/100*amount);
	}

}
