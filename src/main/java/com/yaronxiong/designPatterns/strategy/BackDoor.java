package com.yaronxiong.designPatterns.strategy;

public class BackDoor implements IStrategy {
	@Override
	public void operator() {
		System.out.println("走后门");
	}
}
