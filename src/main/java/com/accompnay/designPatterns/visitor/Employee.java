package com.accompnay.designPatterns.visitor;

public abstract class Employee {
	public static final int FEMALE = 1;
	public static final int MALE = 0;

	private String name;
	private int salary;
	private int sex;
	private IVisitor visitor;

	public void accept(IVisitor visitor){
		this.visitor = visitor;
	}

	public abstract void report();


	public IVisitor getVisitor() {
		return visitor;
	}

	public static int getFemale() {
		return FEMALE;
	}

	public static int getMale() {
		return MALE;
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

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}
}
