package com.accompnay.designPatterns.mediator;

public class Mediator extends AbstractMediator {

	@Override
	protected void fight() {
		department.selfFunction();
		ministry.selfFunction();
	}

	@Override
	protected void buildPalace() {
		defense.selfFunction();
		department.selfFunction();
	}

	@Override
	protected void dealDisaster() {
		defense.selfFunction();
		ministry.selfFunction();
	}
}
