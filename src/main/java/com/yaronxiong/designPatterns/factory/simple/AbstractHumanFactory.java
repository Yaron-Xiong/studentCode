package com.yaronxiong.designPatterns.factory.simple;

/**
 * 生产人类的工厂类
 */
public interface AbstractHumanFactory {
	/**
	 * 由调用者决定返回具体的Human实现类
	 */
	<T extends Human> Human createHuman(Class<T> t);
}
