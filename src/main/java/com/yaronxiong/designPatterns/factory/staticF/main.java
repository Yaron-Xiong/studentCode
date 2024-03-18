package com.yaronxiong.designPatterns.factory.staticF;

import com.yaronxiong.designPatterns.factory.simple.Human;
import com.yaronxiong.designPatterns.factory.simple.YellowHuman;

public class main {
	public static void main(String[] args) {
		Human human = StaticHumanFactory.createHuman(YellowHuman.class);
		human.getColor();
		human.talk();
	}
}
