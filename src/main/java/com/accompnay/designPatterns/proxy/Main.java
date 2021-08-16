package com.accompnay.designPatterns.proxy;

/**
 * 代理模式
 */
public class Main {
	public static void main(String[] args) {
		GamePlayer player = new GamePlayer();
		IGamePlayer gamePlayer = new GamePlayerProxy(player);
		gamePlayer.login();
		gamePlayer.killBoss();
		gamePlayer.upGrade();
	}
}
