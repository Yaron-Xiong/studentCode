package com.accompnay.designPatterns.factory.single;

public class main {
	public static void main(String[] args) {
		SingleFactory singleFactory = new SingleFactory();
		Sun sun = singleFactory.getSingleSun();
		sun.detail();
	}
}
