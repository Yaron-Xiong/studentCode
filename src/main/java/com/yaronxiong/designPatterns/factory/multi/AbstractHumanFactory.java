package com.yaronxiong.designPatterns.factory.multi;

import com.yaronxiong.designPatterns.factory.simple.Human;

public interface AbstractHumanFactory {
	Human createHuman();

	/**
	 * 这个方法在工厂类中，是不是破坏了单一职责原则?
	 */
	static  <T extends AbstractHumanFactory> AbstractHumanFactory getHumanFactory(Class<T> t) {
		AbstractHumanFactory humanFactory = null;
		try {
			humanFactory = (AbstractHumanFactory) Class.forName(t.getName()).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return humanFactory;
	}
}
