package com.accompnay.designPatterns.factory.staticF;

import com.accompnay.designPatterns.factory.simple.Human;

/**
 * 静态工厂，一种比较简单的工厂模式
 *  缺点：因为缺失了抽象层，导致扩展性在一定程度上会下降，但是简单啊~在产品类和工厂都不复杂的时候 弄那么复杂干啥？
 */
public class StaticHumanFactory {

	public static <T extends Human> Human createHuman(Class<T> t) {
		Human human;
		try {
			human = (Human) Class.forName(t.getName()).newInstance();
		} catch (Exception e) {
			throw new RuntimeException("未知类型");
		}
		return human;
	}
}
