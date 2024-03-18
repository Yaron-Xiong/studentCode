package com.yaronxiong.designPatterns.composite;

public class Manager extends AbstractNode {

	public Manager(String name, int salary, String position) {
		super(name, salary, position);
	}

	@Override
	public void getInfo() {
		System.out.println(getName()+":"+getSalary()+":"+getPosition()+":"+"我可是管理层呢");
	}

}
