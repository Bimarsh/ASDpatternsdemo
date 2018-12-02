package com.state;

public class SilverState implements AccountState {

	@Override
	public void addFlights(int miles, AccountContext context) {
		int numberOfFlights= context.getNumberOfFlights();
		context.setNumberOfFlights(numberOfFlights++);
		int currentMiles=context.getNumberOfMiles();
		currentMiles= currentMiles+miles;
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
{
	}
		
	}

}
