package com.yaronxiong.designPatterns.command;

public class RequiremntGroup implements Group {
	@Override
	public void find() {
		System.out.println("需求组 找到");
	}

	@Override
	public void add() {
		System.out.println("需求组 添加");
	}

	@Override
	public void del() {
		System.out.println("需求组 删除");
	}

	@Override
	public void plan() {
		System.out.println("需求组 重新制定");
	}
}
