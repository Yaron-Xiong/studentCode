package com.accompnay.designPatterns.factory.multi;

import com.accompnay.designPatterns.factory.simple.Human;
import com.accompnay.designPatterns.factory.simple.WhiteHuman;

public class WhiteHumanFactory implements AbstractHumanFactory{
	@Override
	public Human createHuman() {
		return new WhiteHuman();
	}
}
