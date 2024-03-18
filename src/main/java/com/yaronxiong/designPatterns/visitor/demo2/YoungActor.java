package com.yaronxiong.designPatterns.visitor.demo2;

public class YoungActor extends AbsActor {

	@Override
	public void act(KungFuRole role) {
		System.out.println("最喜欢扮演功夫角色");
	}
}
