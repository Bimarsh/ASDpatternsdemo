package com.main;

public class LowSpeedState implements CeilingFanState {

	@Override
	public void pullGreen(CeilingFan ceilingFan) {
		System.out.println("MediumState");
		ceilingFan.setCeilingFanState(new MediumState());

	}

	@Override
	public void pullRed(CeilingFan ceilingFan) {
		System.out.println("LowSpeedState");
		ceilingFan.setCeilingFanState(new LowSpeedState());
	}

}
