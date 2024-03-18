package com.yaronxiong.designPatterns.mediator;

public abstract class AbstractColleague {

	protected AbstractMediator mediator;

	public AbstractColleague(AbstractMediator mediator) {
		this.mediator = mediator;
	}

	public abstract void selfFunction();
}
