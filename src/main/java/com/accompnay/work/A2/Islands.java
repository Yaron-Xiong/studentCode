package com.accompnay.work.A2;

public class Islands {
	private String name;
	private Integer curNum;
	private Integer maxNum;

	public Islands(String name, String curNum, String maxNum) {
		this.name = name;
		this.curNum = Integer.valueOf(curNum);
		this.maxNum = Integer.valueOf(maxNum);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCurNum() {
		return curNum;
	}

	public void setCurNum(Integer curNum) {
		this.curNum = curNum;
	}

	public Integer getMaxNum() {
		return maxNum;
	}

	public void setMaxNum(Integer maxNum) {
		this.maxNum = maxNum;
	}
}
