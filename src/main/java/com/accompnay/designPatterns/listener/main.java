package com.accompnay.designPatterns.listener;

/**
 * 监听者模式
 */
public class main {
	public static void main(String[] args) {
		Listener listener = new Listener("A");
		Listener listener2 = new Listener("B");

		Person person = new Person("张三");
		person.addListener(listener);
		person.addListener(listener2);

		person.eatFoot();
	}
}
