package com.yaronxiong.designPatterns.bridge;

/**
 * 桥接模式
 */
public class Main {
	public static void main(String[] args) {
		Color color = new BlueColor("blue");
		Round round = new Round("这是一个圆形",color);

	}
}
