package com.yaronxiong.designPatterns.strategy;

public class GivenGreenLight implements IStrategy {
	@Override
	public void operator() {
		System.out.println("开绿灯");
	}
}
