package com.account;

public class CheckingOneptfiveAlgorithm implements InterestBehavior{

	@Override
	public double calculateInterests(double amount) {
		// TODO Auto-generated method stub
		return amount+(1.5/100*amount);
	}

}
