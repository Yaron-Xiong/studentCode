package com.accompnay.designPatterns.factory.multi;

import com.accompnay.designPatterns.factory.simple.BlackHuman;
import com.accompnay.designPatterns.factory.simple.Human;

public class BlackHumanFactory implements AbstractHumanFactory {
	@Override
	public Human createHuman() {
		return new BlackHuman();
	}
}
