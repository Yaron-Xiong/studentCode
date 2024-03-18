package com.yaronxiong.designPatterns.bridge;

public abstract class Color {
	private String name;

	public Color(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
