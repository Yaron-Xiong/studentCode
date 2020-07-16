package com.accompnay.designPatterns.build;

public class BenzCarBuilder extends CarBuilder {
	@Override
	public CarModel build() {
		return new BenzModel(super.getSeqList());
	}
}
