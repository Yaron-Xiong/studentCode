package com.yaronxiong.designPatterns.wrapper;

/**
 * 装饰者模式
 */
public class Main {
	public static void main(String[] args) {
		SchoolReport schoolReport = new FourSchoolReport();
		Decorator decorator = new SortDecorator(schoolReport);
		decorator.report();
		decorator.sign("i'an your father");
	}
}
