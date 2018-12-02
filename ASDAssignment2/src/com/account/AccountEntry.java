package com.account;

import java.time.LocalDate;

public class AccountEntry {

	public AccountEntry(LocalDate date, String amount, String description, String fromAccountNumber,
			String fromPersonName) {
		super();
		this.date = date;
		this.amount = amount;
		this.description = description;
		this.fromAccountNumber = fromAccountNumber;
		this.fromPersonName = fromPersonName;
	}

	LocalDate date;
	String amount;
	String description;
	String fromAccountNumber;
	String fromPersonName;

}
