package com.account;

public class Application {

	public static void main(String[] args) {

		AccountService accountService = new AccountService();
		Account account = accountService.getAccount("1");
		accountService.deposit(account);

	}

}
