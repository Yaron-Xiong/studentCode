package com.yaronxiong.designPatterns.factory.single;

public class Sun {
	/**
	 * 构造参数私有化，禁止创建
	 */
	private Sun(){}

	public void detail(){
		System.out.println("I am Sun");
	}
}
