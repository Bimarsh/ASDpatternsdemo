package com.state;

public class Application {
	 public static void main(String[] args) {
	 AccountContext ffaccount = new AccountContext("213425");
	 ffaccount.addFlight(13000);
	 System.out.println("Accountnr ="+ffaccount.getAccountNumber());
	 System.out.println("Account type ="+ffaccount.getAccountType());
	 System.out.println("miles ="+ffaccount.getNumberOfMiles());

	 ffaccount.addFlight(99000);
	 System.out.println("Accountnr ="+ffaccount.getAccountNumber());
	 System.out.println("Account type ="+ffaccount.getAccountType());
	 System.out.println("miles ="+ffaccount.getNumberOfMiles());
	 }
	} 
