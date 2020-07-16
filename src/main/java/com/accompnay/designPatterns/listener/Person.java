package com.accompnay.designPatterns.listener;

import com.google.common.collect.Lists;

import java.util.List;

public class Person implements IPerson, Listenable {

	private String name;

	private List<IListener> listenerList = Lists.newArrayList();

	public Person(String name) {
		this.name = name;
	}

	@Override
	public void eatFoot() {
		String message = name + "吃饭了";
		System.out.println(message);
		notifyAllListener(message);
	}

	@Override
	public void addListener(IListener listener) {
		listenerList.add(listener);
	}

	@Override
	public void notifyAllListener(String message) {
		for (IListener listener : listenerList) {
			listener.update(message);
		}
	}

}
