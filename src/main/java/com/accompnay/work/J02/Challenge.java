package com.accompnay.work.J02;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class Challenge {

	private static Map<Integer, UserGame> levelBossMap;
	private static final List<Object> locks = new ArrayList<>();
	private static Random random = new Random();

	static {
		levelBossMap = new ConcurrentHashMap<>();
		for (int i = 1; i <= 10; i++) {
			levelBossMap.put(i, new UserGame(String.valueOf(i), i));
			locks.add(new Object());
		}
	}

	private static String mes = "玩家:%s 分数:%s 正在挑战level:%s bossName:%s 分数:%s";
	private static String successMes = "************玩家:%s 分数:%s 挑战成功************";
	private static String failMes = "玩家:%s 分数:%s 挑战失败";

	public static void challenge(int level, String name, int score) {
		synchronized (locks.get(level - 1)) {
			UserGame boss = levelBossMap.get(level);
			System.out.println(String.format(mes, name, score, level, boss.getName(), boss.getScore()));
			if (score > boss.getScore()) {
				int resultScore = score + random.nextInt(4);
				levelBossMap.put(level, new UserGame(name, score));
				System.out.println(String.format(successMes, name, resultScore));
				return;
			}
			System.out.println(String.format(failMes, name, score));
		}
	}

	public static List<String> getBossList() {
		return levelBossMap.values().stream().map(UserGame::getName).collect(Collectors.toList());
	}
}
