package com.account;

public class Logger implements Observer {

	AccountService accountService;
	
	
	@Override
	public void update() {
		System.out.println("Logger: " + AccountService.loggerState);

	}

}
