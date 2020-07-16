package com.accompnay.designPatterns.mediator;

public class Defense extends AbstractColleague {

	public Defense(AbstractMediator mediator) {
		super(mediator);
	}

	public void fight(){
		System.out.println("我是兵部，可以出兵");
		mediator.fight();
	}

	@Override
	public void selfFunction() {
		System.out.println("我是兵部，可以出兵");
	}
}
