package com.accompnay.designPatterns.composite;

import com.google.common.collect.Lists;

import java.util.List;

public abstract class AbstractNode {
	private String name;
	private int salary;
	private String position;
	public List<AbstractNode> subNode;

	public AbstractNode(String name, int salary, String position) {
		this.name = name;
		this.salary = salary;
		this.position = position;
		this.subNode = Lists.newArrayList();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public List<AbstractNode> getSubNode() {
		return subNode;
	}

	public void setSubNode(List<AbstractNode> subNode) {
		this.subNode = subNode;
	}

	public abstract void getInfo();

	public AbstractNode addSubNode(AbstractNode node){
		this.getSubNode().add(node);
		return this;
	}
}
