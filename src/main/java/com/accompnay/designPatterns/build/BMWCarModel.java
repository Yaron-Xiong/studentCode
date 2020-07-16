package com.accompnay.designPatterns.build;

import java.util.List;

public class BMWCarModel extends CarModel {
	public BMWCarModel(List<Model> seq) {
		super(seq);
	}

	@Override
	protected void start() {
		System.out.println("BMW start");
	}

	@Override
	protected void alarm() {
		System.out.println("BMW alarm");
	}

	@Override
	protected void stop() {
		System.out.println("BMW stop");
	}

	@Override
	protected void engineBoom() {
		System.out.println("BMW engineBoom");
	}

}
