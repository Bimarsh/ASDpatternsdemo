package com.account;

public class EmailSender implements Observer {
	
	AccountService accountService;

	@Override
	public void update() {
		System.out.println("Email Sender: "+AccountService.emailState);

	}

}
