package com.main;

public class CeilingFan {
	
	public CeilingFan() {
		this.ceilingFanState = new OffState();
	}

	private CeilingFanState ceilingFanState;

	public CeilingFanState getCeilingFanState() {
		return ceilingFanState;
	}

	public void setCeilingFanState(CeilingFanState ceilingFanState) {
		this.ceilingFanState = ceilingFanState;
	}

	public void pullgreen() {
		ceilingFanState.pullGreen(this);
	}

	public void pullred() {
		ceilingFanState.pullRed(this);
	}
}
