package com.yaronxiong.designPatterns.ChainofCommand;

public abstract class Handler {
	protected static final int FATHER = 1;
	protected static final int HUSBAND = 2;
	protected static final int SON = 3;
	private Handler nextHandler;

	public void setNextHandler(Handler nextHandler){
		this.nextHandler = nextHandler;
	}

	public Handler getNextHandler() {
		return nextHandler;
	}

	public abstract void hand(IWoman woman);
}
