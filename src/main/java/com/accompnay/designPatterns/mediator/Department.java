package com.accompnay.designPatterns.mediator;

public class Department extends AbstractColleague {

	public Department(AbstractMediator mediator) {
		super(mediator);
	}

	public void dealDisaster(){
		selfFunction();
		mediator.dealDisaster();
	}

	@Override
	public void selfFunction() {
		System.out.println("我是户部，可以出钱");
	}
}
