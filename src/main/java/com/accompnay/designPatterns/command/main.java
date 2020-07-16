package com.accompnay.designPatterns.command;

public class main {

	public static void main(String[] args) {
		AddCommand command = new AddCommand();
		Invoker invoker = new Invoker();
		invoker.setCommand(command);
		invoker.execute();

	}
}
