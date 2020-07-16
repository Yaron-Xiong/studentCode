package com.accompnay.designPatterns.memento;

/**
 * 备忘录模式：
 * 备忘录模式结合原型模式可以十分好的设计出备忘录模式
 *
 */
public class main {
	public static void main(String[] args) {
		Task task = new Task();
		task.createMemento();
		System.out.println(task);

		task.setStatus("接受");
		task.createMemento();
		System.out.println(task);

		task.setStatus("已完成");
		System.out.println(task);

		task.reloadLast();
		System.out.println(task);
		task.reloadLast();
		System.out.println(task);
	}
}
