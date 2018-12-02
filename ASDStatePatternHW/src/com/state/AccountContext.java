package com.state;

public class AccountContext {
	
	private AccountState accountState;
	private String accountNumber;
	private String accountType;
	public AccountContext(String aNumber) {
		accountNumber=aNumber;
		this.accountState= new SilverState();
	}
	
	
	public void addFlight(int newMiles) {
		accountState.addFlights(newMiles, this);
	}

	
	public AccountState getAccountState() {
		return accountState;
	}
	public void setAccountState(AccountState accountState) {
		this.accountState = accountState;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public int getNumberOfMiles() {
		return numberOfMiles;
	}
	public void setNumberOfMiles(int numberOfMiles) {
		this.numberOfMiles = numberOfMiles;
	}
	public int getNumberOfFlights() {
		return numberOfFlights;
	}
	public void setNumberOfFlights(int numberOfFlights) {
		this.numberOfFlights = numberOfFlights;
	}
	private int numberOfMiles;
	private int numberOfFlights;
	

}
