package com.accompnay.designPatterns.listener;

public interface Listenable {
	void addListener(IListener IListener);
	void notifyAllListener(String message);
}
