package com.accompnay.designPatterns.strategy;

public class Context {
	private IStrategy strategy;

	public Context(IStrategy strategy) {
		this.strategy = strategy;
	}

	public void operator(){
		strategy.operator();
	}

}
