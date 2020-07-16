package com.accompnay.designPatterns.factory.delay;

import java.util.HashMap;
import java.util.Map;

/**
 * 这里是不是会存在一个问题？
 * 如果没有估计好对象的数量会造成OOM？如果很大的话 是不是可以采用淘汰算法了？
 */
public class CityFactory {
	private Map<String, City> cache = new HashMap<>();
	public City createCity(String cityName) {
		//避免重复创建对象
		if (!cache.containsKey(cityName)) {
			synchronized (this) {
				if (!cache.containsKey(cityName)) {
					System.out.println("缓存中没有" + cityName + "，正在创建...");
					//这里一定是创建好的city对象，是不会像单例模式中的懒汉式需要加volatile
					City city = new City(cityName);
					cache.put(city.getName(), city);
				}
			}
		}
		return cache.get(cityName);
	}

}
