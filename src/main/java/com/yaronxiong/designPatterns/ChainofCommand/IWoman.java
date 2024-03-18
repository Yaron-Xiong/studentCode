package com.yaronxiong.designPatterns.ChainofCommand;

public abstract class IWoman {

	private int type;
	private String want;
	public IWoman(int type,String want) {
		this.type = type;
		this.want = want;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getWant() {
		return want;
	}

	public abstract void want();

}
