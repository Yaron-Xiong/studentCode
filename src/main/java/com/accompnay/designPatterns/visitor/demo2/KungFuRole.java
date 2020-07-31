package com.accompnay.designPatterns.visitor.demo2;

public class KungFuRole implements IRole {

	@Override
	public void accept(AbsActor actor) {
		actor.act(this);
	}
}
