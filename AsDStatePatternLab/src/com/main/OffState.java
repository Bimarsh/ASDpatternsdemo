package com.main;

public class OffState implements CeilingFanState {

	@Override
	public void pullGreen(CeilingFan ceilingFan) {
		System.out.println("LowSpeedState");
		ceilingFan.setCeilingFanState(new LowSpeedState());
		
	}

	@Override
	public void pullRed(CeilingFan ceilingFan) {
		System.out.println("HighSpeedState");
		ceilingFan.setCeilingFanState(new HighSpeedState());
	}

}
