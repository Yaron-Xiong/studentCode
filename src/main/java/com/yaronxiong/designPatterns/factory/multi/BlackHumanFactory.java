package com.yaronxiong.designPatterns.factory.multi;

import com.yaronxiong.designPatterns.factory.simple.BlackHuman;
import com.yaronxiong.designPatterns.factory.simple.Human;

public class BlackHumanFactory implements AbstractHumanFactory {
	@Override
	public Human createHuman() {
		return new BlackHuman();
	}
}
