package com.yaronxiong.designPatterns.mediator;

public abstract class AbstractMediator {
	/**
	 * 户部
	 */
	protected AbstractColleague department;
	/**
	 * 工部
	 */
	AbstractColleague ministry;
	/**
	 * 兵部
	 */
	protected AbstractColleague defense;


	protected abstract void fight();

	protected abstract void buildPalace();

	protected abstract void dealDisaster();

	public AbstractMediator() {
		this.department = new Department(this);
		this.ministry = new Ministry(this);
		this.defense = new Defense(this);
	}

}
