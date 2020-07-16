package com.accompnay.designPatterns.abstractF;

/**
 *
 */
public class main {
	public static void main(String[] args) {
		AbstractHumanFactory factory = AbstractHumanFactory.getHumanFactory(MaleFactory.class);
		Human yellowHuman = factory.createYellowHuman();
		yellowHuman.getColor();
		yellowHuman.getSex();
	}
}
