package com.yaronxiong.work.A2;

public class Islands {
	private String name;
	private int curNum;
	private int maxNum;

	public Islands(String name, String curNum, String maxNum) {
		this.name = name;
		this.curNum = Integer.parseInt(curNum);
		this.maxNum = Integer.parseInt(maxNum);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCurNum() {
		return curNum;
	}

	public void setCurNum(Integer curNum) {
		this.curNum = curNum;
	}

	public int getMaxNum() {
		return maxNum;
	}

	public void setMaxNum(Integer maxNum) {
		this.maxNum = maxNum;
	}
}
