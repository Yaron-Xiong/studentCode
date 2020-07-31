package com.accompnay.designPatterns.visitor.demo2;

public class main {
	public static void main(String[] args) {
		IRole iRole = new KungFuRole();
		AbsActor oldActor = new OldActor();
		iRole.accept(oldActor);
	}
}
