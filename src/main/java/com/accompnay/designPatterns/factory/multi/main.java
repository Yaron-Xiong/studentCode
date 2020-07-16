package com.accompnay.designPatterns.factory.multi;

import com.accompnay.designPatterns.factory.simple.Human;
import com.accompnay.designPatterns.factory.simple.HumanFactory;
import com.accompnay.designPatterns.factory.simple.YellowHuman;

/**
 * 针对每个产品类都有对应的工厂,由上层决定生产什么就使用什么工厂
 *  好处：
 *      1.符合单一职责原则 （因为一个工厂就生产某个具体的产品）
 *  坏处：
 *      1.如果新增一个产品就需要新增一个工厂类
 *
 */
public class main {
	public static void main(String[] args) {
		
	}
}
