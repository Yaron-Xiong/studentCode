package com.yaronxiong.designPatterns.mediator;

public class main {
	public static void main(String[] args) {
		Mediator mediator = new Mediator();
		//mediator.buildPalace();

		Department department = new Department(mediator);
		department.dealDisaster();
	}
}
