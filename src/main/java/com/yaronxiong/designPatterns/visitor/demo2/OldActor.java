package com.yaronxiong.designPatterns.visitor.demo2;

public class OldActor extends AbsActor{
	@Override
	public void act(KungFuRole role) {
		System.out.println("年纪大了 扮演不了功夫角色");
	}
}
