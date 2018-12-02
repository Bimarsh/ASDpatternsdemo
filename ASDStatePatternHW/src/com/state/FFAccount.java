package com.state;

public class FFAccount {
	private String accountNumber;
	private String accountType;
	private int numberOfMiles;
	private int numberOfFlights;
	AccountState state;

	public FFAccount(String aNumber) {
		accountNumber = aNumber;
		accountType = "silver";
		this.state=new SilverState();
	}

	public void addFlight(int newMiles) {
		if (accountType.equals("silver")) {
			numberOfMiles += newMiles;
			numberOfFlights++;
			checkForUpgrade();
		} else {
			if (accountType.equals("gold")) {
				numberOfMiles += (2 * newMiles);
				numberOfFlights++;
			}
		}
	}

	public void checkForUpgrade() {
		if ((numberOfMiles > 100000) || (numberOfFlights > 95)) {
			accountType = "gold";
		}
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

	public int getNumberOfFlights() {
		return numberOfFlights;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
}