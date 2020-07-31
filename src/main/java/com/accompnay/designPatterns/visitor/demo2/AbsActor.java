package com.accompnay.designPatterns.visitor.demo2;

import javax.xml.bind.SchemaOutputResolver;

public abstract class AbsActor {
	public void act(IRole role){
		System.out.println("演员可以扮演所有角色");
	}

	public void act(KungFuRole role){
		System.out.println("演员可以扮演功夫角色");
	}

	public void act(IdiotRole idiotRole){
		System.out.println("演员可以扮演智障角色");
	}
}
