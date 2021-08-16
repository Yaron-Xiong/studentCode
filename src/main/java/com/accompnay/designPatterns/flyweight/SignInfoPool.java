package com.accompnay.designPatterns.flyweight;

/**
 * 作为缓存的唯一标识
 */
public class SignInfoPool extends SignInfo{
	private String key;

	public SignInfoPool(String key) {
		this.key = key;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
}
