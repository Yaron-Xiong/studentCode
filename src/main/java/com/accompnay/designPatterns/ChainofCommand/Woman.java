package com.accompnay.designPatterns.ChainofCommand;

public class Woman extends IWoman{

	public Woman(int type, String want) {
		super(type, want);
	}

	@Override
	public void want() {
		System.out.println(getWant());
	}
}
