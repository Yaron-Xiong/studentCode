package com.accompnay.designPatterns.proxy;

public class GamePlayer implements IGamePlayer {
	@Override
	public void login() {
		System.out.println("玩家登入");
	}

	@Override
	public void killBoss() {
		System.out.println("玩家击杀Boss");
	}

	@Override
	public void upGrade() {
		System.out.println("玩家升级");
	}
}
