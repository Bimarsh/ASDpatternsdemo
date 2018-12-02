package com.main;

public class MediumState implements CeilingFanState {

	@Override
	public void pullGreen(CeilingFan ceilingFan) {
		System.out.println("HighSpeedState");
		ceilingFan.setCeilingFanState(new HighSpeedState());

	}

	@Override
	public void pullRed(CeilingFan ceilingFan) {
		System.out.println("LowSpeedState");
		ceilingFan.setCeilingFanState(new LowSpeedState());
	}

}
