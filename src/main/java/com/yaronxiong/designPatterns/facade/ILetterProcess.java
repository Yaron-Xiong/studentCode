package com.yaronxiong.designPatterns.facade;

public interface ILetterProcess {
	void writeContext(String context);
	void fillEnvelope(String name);
	void letterIntoEnvelope();
	void sendLetter();
}
