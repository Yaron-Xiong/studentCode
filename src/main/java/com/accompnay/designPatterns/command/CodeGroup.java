package com.accompnay.designPatterns.command;

public class CodeGroup implements Group {
	@Override
	public void find() {
		System.out.println("代码组");
	}

	@Override
	public void add() {
		System.out.println("添加代码需求");
	}

	@Override
	public void del() {
		System.out.println("删除代码需求");
	}

	@Override
	public void plan() {
		System.out.println("架构更换");
	}
}
