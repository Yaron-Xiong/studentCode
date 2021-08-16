package com.accompnay.designPatterns.facade;

public class LetterProcess implements ILetterProcess {
	@Override
	public void writeContext(String context) {
		System.out.println("信的内容为::"+context);
	}

	@Override
	public void fillEnvelope(String name) {
		System.out.println("收信人::"+name);
	}

	@Override
	public void letterIntoEnvelope() {
		System.out.println("将信丢进信封");
	}

	@Override
	public void sendLetter() {
		System.out.println("送信啦");
	}
}
