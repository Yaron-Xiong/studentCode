package com.accompnay.designPatterns.flyweight;

/**
 * 享元模式
 * 共享内存，做到减少不必要的重复内存=》也就是缓存
 */
public class Main {
	public static void main(String[] args) {
		for (int i = 0; i < 4; i++) {
			String subject = "科目" + i;
			for (int j = 0; j < 30; j++) {
				String key = subject + "考试地点" + j;
				SignInfoFactory.getInstance(key);
			}
		}
		SignInfoPool instance = SignInfoFactory.getInstance("科目2考试地点2");
		System.out.println(instance.getKey());
	}
}
