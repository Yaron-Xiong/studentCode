package com.accompnay.designPatterns.listener;

public class Listener implements IListener {
	private String name;

	public Listener(String name) {
		this.name = name;
	}

	@Override
	public void update(String message) {
		System.out.println(name+"监听者来了，监听到了"+message);
	}
}
