package com.state;

public class GoldState implements AccountState{

	@Override
	public void addFlights(int number, AccountContext context) {
		int numberOfFlights= context.getNumberOfFlights();
		context.setNumberOfFlights(numberOfFlights++);
		int currentMiles=context.getNumberOfMiles();
		currentMiles= currentMiles+2*number;
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
