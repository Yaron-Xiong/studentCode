package com.accompnay.designPatterns.factory.multi;

import com.accompnay.designPatterns.factory.simple.Human;
import com.accompnay.designPatterns.factory.simple.YellowHuman;

public class YellowHumanFactory implements AbstractHumanFactory {

	@Override
	public Human createHuman() {
		return new YellowHuman();
	}
}
