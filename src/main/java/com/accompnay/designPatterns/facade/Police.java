package com.accompnay.designPatterns.facade;

public class Police {
	public static void checkLetter(ILetterProcess iLetterProcess){
		System.out.println(iLetterProcess+"已经检查完毕");
	}
}
