package com.yaronxiong.designPatterns.factory.single;

import java.lang.reflect.Constructor;

/**
 * 通过反射创建
 */
public class SingleFactory {
	private volatile Sun sun;

	public Sun getSingleSun() {
		if (sun == null) {
			synchronized (SingleFactory.class) {
				if (sun == null) {
					try {
						//因为是私有构造函数所以需要获得强制访问权,如果不这样做会报错
						Class<Sun> sunClass = Sun.class;
						Constructor<Sun> sunConstructor = sunClass.getDeclaredConstructor();
						sunConstructor.setAccessible(true);
						this.sun = sunConstructor.newInstance();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		return sun;
	}
}
