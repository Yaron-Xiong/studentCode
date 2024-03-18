package com.yaronxiong.designPatterns.factory.multi;

import com.yaronxiong.designPatterns.factory.simple.Human;
import com.yaronxiong.designPatterns.factory.simple.YellowHuman;

public class YellowHumanFactory implements AbstractHumanFactory {

	@Override
	public Human createHuman() {
		return new YellowHuman();
	}
}
