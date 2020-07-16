package com.accompnay.designPatterns.abstractF;

public abstract class AbstractYellowHuman implements Human {
	@Override
	public void getColor() {
		System.out.println("黄色");
	}

	@Override
	public void talk() {
		System.out.println("我是黄色");
	}
}
