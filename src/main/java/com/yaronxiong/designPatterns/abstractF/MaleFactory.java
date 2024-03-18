package com.yaronxiong.designPatterns.abstractF;


/**
 * 生产男人的车间
 */
public class MaleFactory implements AbstractHumanFactory {
	/**
	 * 生产黄皮肤男人，流水线
	 */
	@Override
	public Human createYellowHuman() {
		return new MaleYellowHuman();
	}

	/**
	 * 生产黑皮肤男人，流水线
	 */
	@Override
	public Human createBlackHuman() {
		return null;
	}

	/**
	 * 生产白皮肤男人，流水线
	 */
	@Override
	public Human createWhiteHuman() {
		return null;
	}
}
