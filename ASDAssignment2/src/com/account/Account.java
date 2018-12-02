package com.account;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Account {
	
	public InterestBehavior calculateInterest;
	
	public InterestBehavior getCalculateInterest() {
		return calculateInterest;
	}

	public void setCalculateInterestAlgorithm(InterestBehavior calculateInterest) {
		this.calculateInterest = calculateInterest;
	}

	public double calculateInterest(double amount)
	{
		return calculateInterest.calculateInterests(amount);
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	String accountNumber;

	Customer customer;

	public Account(String accountNumber, Customer customer, List<AccountEntry> accountEntries) {
		super();
		this.accountNumber = accountNumber;
		this.customer = customer;
		this.accountEntries = accountEntries;
	}

	List<AccountEntry> accountEntries = new ArrayList<>();

	public List<AccountEntry> getAccountEntries() {
		return accountEntries;
	}

	public void setAccountEntries(List<AccountEntry> accountEntries) {
		this.accountEntries = accountEntries;
	}

	public Account createAccountEntries() {
		AccountEntry entry = new AccountEntry(LocalDate.now(), "100", "adfad", this.accountNumber,
				this.customer.getName());
		this.getAccountEntries().add(entry);
		return this;
	}

}
