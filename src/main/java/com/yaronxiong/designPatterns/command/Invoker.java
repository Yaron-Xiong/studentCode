package com.yaronxiong.designPatterns.command;

public class Invoker {
	private Command command;
	public void execute(){
		command.execute();
	}

	public void setCommand(Command command){
		this.command = command;
	}
}
