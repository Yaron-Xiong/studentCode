package com.accompnay.designPatterns.abstractP;

public class HummerH1 extends HummerModel {
	private boolean isAlarm;
	@Override
	protected void start() {
		System.out.println("H1 start");
	}

	@Override
	protected void stop() {
		System.out.println("H1 stop");
	}

	@Override
	protected void alarm() {
		System.out.println("H1 alarm");
	}

	@Override
	protected void engineBoom() {
		System.out.println("H1 engine");
	}



}
