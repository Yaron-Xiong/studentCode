package com.accompnay.designPatterns.factory.simple;

public class BlackHuman implements Human{
	@Override
	public void getColor() {
		System.out.println("黑色");
	}

	@Override
	public void talk() {
		System.out.println("我是黑色");
	}
}
