package com.accompnay.designPatterns.factory.simple;

public class YellowHuman implements  Human{
	@Override
	public void getColor() {
		System.out.println("黄色");
	}

	@Override
	public void talk() {
		System.out.println("我是黄色");
	}
}
