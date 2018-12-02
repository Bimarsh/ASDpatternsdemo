package com.account;

import java.util.ArrayList;
import java.util.List;

public class AccountChangeObservarable {

	List<Observer> listOfObservers = new ArrayList<>();
	{
		Observer logger = new Logger();
		Observer smsSender= new SMSSender();
		Observer emailSender= new EmailSender();
		attachObserver(logger);
		attachObserver(smsSender);
		attachObserver(emailSender);

	}

	public void attachObserver(Observer observer) {

		listOfObservers.add(observer);

	}

	public void detachObserver(Observer observer) {
		listOfObservers.remove(observer);
	}

	public void notifiy() {
		for (Observer observer : listOfObservers) {
			observer.update();
		}
	}

}
