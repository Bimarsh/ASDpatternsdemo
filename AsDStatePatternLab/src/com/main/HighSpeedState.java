package com.main;

public class HighSpeedState implements CeilingFanState {

	@Override
	public void pullGreen(CeilingFan ceilingFan) {
		System.out.println("OffState");
		ceilingFan.setCeilingFanState(new OffState());

	}

	@Override
	public void pullRed(CeilingFan ceilingFan) {
		System.out.println("MediumState");
		ceilingFan.setCeilingFanState(new MediumState());

	}

}
