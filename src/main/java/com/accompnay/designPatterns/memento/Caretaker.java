package com.accompnay.designPatterns.memento;

import java.util.Stack;

public class Caretaker {
	private Stack<Task> mementos;

	public Caretaker() {
		this.mementos = new Stack<>();
	}

	public void addMemento(Task memento){
		mementos.push(memento);
	}

	public Task getLastMemento(){
		return mementos.pop();
	}
}
