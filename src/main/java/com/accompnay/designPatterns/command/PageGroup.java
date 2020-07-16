package com.accompnay.designPatterns.command;

public class PageGroup implements Group {
	@Override
	public void find() {
		System.out.println("我是美术组");
	}

	@Override
	public void add() {
		System.out.println("添加美术需求");
	}

	@Override
	public void del() {
		System.out.println("删除美术需求");
	}

	@Override
	public void plan() {
		System.out.println("页面变更");
	}
}
