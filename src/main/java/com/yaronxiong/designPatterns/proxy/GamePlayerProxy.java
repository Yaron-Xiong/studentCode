package com.yaronxiong.designPatterns.proxy;

public class GamePlayerProxy implements IGamePlayer {
	private GamePlayer gamePlayer;

	public GamePlayerProxy(GamePlayer gamePlayer) {
		this.gamePlayer = gamePlayer;
	}

	@Override
	public void login() {
		gamePlayer.login();
	}

	@Override
	public void killBoss() {
		gamePlayer.killBoss();
	}

	@Override
	public void upGrade() {
		gamePlayer.upGrade();
	}
}
