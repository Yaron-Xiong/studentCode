package com.accompnay.work.J02;

import java.util.List;
import java.util.Random;

public class Main {

	private static final Random random = new Random();

	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			int score = random.nextInt(5);
			int challengeLevel = random.nextInt(11);
			challengeLevel = challengeLevel == 0 ? 1 : challengeLevel;
			UserRunnable userRunnable = new UserRunnable(String.valueOf(i), score, challengeLevel);
			Thread thread = new Thread(userRunnable, "Thread_UserGame" + i);
			thread.start();
		}
	}

	public static class UserRunnable implements Runnable {
		private String name;
		private Integer score;
		private Integer challengeLevel;

		public UserRunnable(String name, Integer score, Integer challengeLevel) {
			this.name = name;
			this.score = score;
			this.challengeLevel = challengeLevel;
		}

		@Override
		public void run() {
			Challenge.challenge(challengeLevel, name, score);
			if (Integer.parseInt(name) % 5 == 0) {
				List<String> bossList = Challenge.getBossList();
				System.out.println("当前Boss排行榜" + bossList);
			}
		}
	}
}
