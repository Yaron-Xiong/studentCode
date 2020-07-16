package com.accompnay.designPatterns.factory.simple;

import com.accompnay.designPatterns.factory.multi.AbstractHumanFactory;
import com.accompnay.designPatterns.factory.multi.BlackHumanFactory;
import com.accompnay.designPatterns.factory.multi.YellowHumanFactory;

/**
 * 多工厂模式：针对每个产品都对应一个工厂
 *  好处：
 *      1.相比于但单个工厂，面对多个产品能够更加具体去创建对象（虽然单个工厂也行，但是是不是代码复杂？）
 *      2.更加符合单一职责原则？
 *  坏处：
 *      1.新增一个产品就需要新增一个工厂对应,复杂度提升
 *      2.上层需要知道某个具体的工厂才能获取某个产品（需要再来一个工厂方法根据产品获取工厂？ 简化？）
 *
 *
 */
public class main {
	public static void main(String[] args) {
		AbstractHumanFactory humanFactory = AbstractHumanFactory.getHumanFactory(BlackHumanFactory.class);
		Human human = humanFactory.createHuman();
		human.getColor();
		human.talk();
	}
}
