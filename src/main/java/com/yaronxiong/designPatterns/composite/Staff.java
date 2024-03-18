package com.yaronxiong.designPatterns.composite;

public class Staff extends AbstractNode {
	public Staff(String name, int salary, String position) {
		super(name, salary, position);
	}

	@Override
	public void getInfo() {
		System.out.println(getName()+":"+getSalary()+":"+getPosition()+":"+"我是一个打工仔");
	}
}
