package com.accompnay.designPatterns.facade;

public class ModePostOffice {

	public void sendLetter(String letterContext, String name) {
		ILetterProcess letterProcess = new LetterProcess();
		letterProcess.writeContext(letterContext);
		letterProcess.fillEnvelope(name);
		Police.checkLetter(letterProcess);
		letterProcess.letterIntoEnvelope();
		letterProcess.sendLetter();
	}
}
