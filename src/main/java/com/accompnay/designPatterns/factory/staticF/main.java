package com.accompnay.designPatterns.factory.staticF;

import com.accompnay.designPatterns.factory.simple.Human;
import com.accompnay.designPatterns.factory.simple.HumanFactory;
import com.accompnay.designPatterns.factory.simple.YellowHuman;

public class main {
	public static void main(String[] args) {
		Human human = StaticHumanFactory.createHuman(YellowHuman.class);
		human.getColor();
		human.talk();
	}
}
