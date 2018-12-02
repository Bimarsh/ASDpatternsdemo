package com.state;

public class PlatinumState implements AccountState {

	@Override
	public void addFlights(int number, AccountContext context) {
		int numberOfFlights= context.getNumberOfFlights();
		context.setNumberOfFlights(numberOfFlights*2);
		int currentMiles=context.getNumberOfMiles();
		currentMiles= currentMiles+3*number;
		context.setNumberOfMiles(currentMiles);
		checkForUpgrade(context);
		
	}

	@Override
	public void checkForUpgrade(AccountContext context) {
		if ((context.getNumberOfMiles() > 75000 && context.getNumberOfMiles()<150000) || (context.getNumberOfFlights() > 75&&context.getNumberOfFlights()<145)) {
			context.setAccountState(new GoldState());
		}
		else if((context.getNumberOfMiles()>150000)||(context.getNumberOfFlights()>145))
		{
			context.setAccountState(new PlatinumState());
		}
	}

}
