package com.accompnay.designPatterns.build;

import java.util.List;

public class BenzModel extends CarModel {

	public BenzModel(List<Model> seq) {
		super(seq);
	}

	@Override
	protected void start() {
		System.out.println("Benz start");
	}

	@Override
	protected void alarm() {
		System.out.println("Benz alarm");
	}

	@Override
	protected void stop() {
		System.out.println("Benz stop");
	}

	@Override
	protected void engineBoom() {
		System.out.println("Benz engineBoom");
	}

}
