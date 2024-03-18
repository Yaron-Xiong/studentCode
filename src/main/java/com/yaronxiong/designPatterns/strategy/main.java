package com.yaronxiong.designPatterns.strategy;

public class main {
	public static void main(String[] args) {
		System.out.println("*********第一个策略*********");
		Context context = new Context(new BackDoor());
		context.operator();

		System.out.println("*********第二个策略*********");
		context = new Context(new BlockEnemy());
		context.operator();

		System.out.println("*********第三个策略*********");
		context = new Context(new GivenGreenLight());
		context.operator();

	}
}
