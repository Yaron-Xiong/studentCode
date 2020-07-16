package com.accompnay.designPatterns.mediator;

public class Ministry extends AbstractColleague {

	public Ministry(AbstractMediator mediator) {
		super(mediator);
	}

	public void buildPalace(){
		selfFunction();
		mediator.buildPalace();
	}

	@Override
	public void selfFunction() {
		System.out.println("我是工部，可以画图纸，建房子");
	}
}
