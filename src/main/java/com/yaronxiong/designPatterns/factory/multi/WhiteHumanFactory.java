package com.yaronxiong.designPatterns.factory.multi;

import com.yaronxiong.designPatterns.factory.simple.Human;
import com.yaronxiong.designPatterns.factory.simple.WhiteHuman;

public class WhiteHumanFactory implements AbstractHumanFactory{
	@Override
	public Human createHuman() {
		return new WhiteHuman();
	}
}
