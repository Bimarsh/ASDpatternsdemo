package com.account;

public class SMSSender implements Observer {
	
	AccountService accountService;

	@Override
	public void update() {
		System.out.println("SMSSender: " + AccountService.smsState);

	}

}
