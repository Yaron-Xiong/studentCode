package com.accompnay.designPatterns.factory.simple;

/**
 * 如果将所有产品都交由HumanFactory生产，那么createHuman可能会复杂（因为可能每个具体的实现类生产的规则不同）
 * 而且也违背了单一职责原则（因为这个工厂负责太多产品的生产啦）
 * 由上述可以引发出 单一具体实现类的对应一个具体的工厂（多工厂模式）
 */
public class HumanFactory implements AbstractHumanFactory {
	@Override
	public <T extends Human> Human createHuman(Class<T> t) {
		Human human;
		try {
			human = (Human) Class.forName(t.getName()).newInstance();
		} catch (Exception e) {
			throw new RuntimeException("未知类型");
		}
		return human;
	}
}
