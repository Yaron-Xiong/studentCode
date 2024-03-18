package com.yaronxiong.designPatterns.build;


public class main {
	public static void main(String[] args) {
		Director director = new Director();
		BenzModel benzModel = director.buildBenzModel();
		benzModel.run();
	}
}
