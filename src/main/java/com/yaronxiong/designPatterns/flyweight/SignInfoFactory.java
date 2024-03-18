package com.yaronxiong.designPatterns.flyweight;

import java.util.HashMap;
import java.util.Map;

public class SignInfoFactory {
	private volatile static Map<String, SignInfoPool> cache = new HashMap<>();

	@Deprecated
	public static SignInfo getInstance() {
		return new SignInfo();
	}

	public static SignInfoPool getInstance(String key) {
		SignInfoPool signInfoPool = cache.get(key);
		if (signInfoPool == null) {
			synchronized (SignInfoFactory.class) {
				if (signInfoPool == null) {
					System.out.println("正在初始化"+key);
					signInfoPool = new SignInfoPool(key);
					cache.put(key, signInfoPool);
				}
			}
		}
		return signInfoPool;
	}
}
