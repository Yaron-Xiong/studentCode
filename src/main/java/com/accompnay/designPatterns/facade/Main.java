package com.accompnay.designPatterns.facade;

/**
 * 外观模式；门面模式
 */
public class Main {
	public static void main(String[] args) {
		/*ILetterProcess letterProcess = new LetterProcess();
		letterProcess.writeContext("我想你了");
		letterProcess.fillEnvelope("yyx");
		letterProcess.letterIntoEnvelope();
		letterProcess.sendLetter();*/

		//以下为外观模式
		ModePostOffice modePostOffice = new ModePostOffice();
		modePostOffice.sendLetter("我想你了aaaa","yyx");
	}

}
