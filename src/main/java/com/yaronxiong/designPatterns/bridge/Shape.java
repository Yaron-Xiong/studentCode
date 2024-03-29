package com.yaronxiong.designPatterns.bridge;

public abstract class Shape {
	private String name;
	private Color color;

	public Shape(String name, Color color) {
		this.name = name;
		this.color = color;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
