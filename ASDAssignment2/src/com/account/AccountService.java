package com.account;

public class AccountService extends AccountChangeObservarable {

	static String loggerState;
	static String smsState;
	static String emailState;

	AccountDao accountdao = new AccountDao();

	void createAccount(Account account) {
		accountdao.saveAccount(account);
		loggerState = "Account Created";
		emailState = "sending email to " + account.getCustomer().getName();
		smsState = "sending sms to " + account.getCustomer().getName();
		notifiy();
	}

	void deposit(Account account) {
		account.createAccountEntries();
		accountdao.updateAccount(account);
		loggerState = "Amount deposited";
		smsState = "sending sms to " + account.getCustomer().getName();
		notifiy();

	}

	void withdraw(Account account) {

		loggerState = "amount withdrawn";
		smsState = "sending sms to " + account.getCustomer().getName();
		notifiy();

	}

	void transferFunds(Account from, Account to) {

		loggerState = "amount transfered";
		smsState = "sending sms to " + from.getCustomer().getName() + "and " + to.getCustomer().getName();
		notifiy();
	}

	void getAllAccounts() {
	}

	Account getAccount(String accountNumber) {

		return accountdao.loadAccount(accountNumber);
	}
	
	public void addInterest(Account account, double amount)
	{
		if(account instanceof CheckingsAccount)
		{
			if(amount<1000)
			{
				account.setCalculateInterestAlgorithm(new Checking2pt5Algorithm());
				
			}
			if(amount>1000)
			{
				account.setCalculateInterestAlgorithm(new CheckingOneptfiveAlgorithm());
				
			}
		}
		else {
			if(amount<1000)
			{
				account.setCalculateInterestAlgorithm(new Saving1percentAlgorithm());
				
			}
			if(amount>1000 && amount<5000)
			{
				account.setCalculateInterestAlgorithm(new Saving2perceAlgorithm());
				
			}
			if(amount>5000)
			{
				account.setCalculateInterestAlgorithm(new Saving4percAlgorithm());
				
			}
			
			
		}
		double cumulativeAmmount=account.calculateInterest(amount);
		
	}

}
