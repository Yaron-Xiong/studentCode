package com.yaronxiong.designPatterns.build;

import java.util.List;

public abstract class CarModel {
	private List<Model> seq;

	public CarModel(List<Model> seq) {
		this.seq = seq;
	}

	protected abstract void start();

	protected abstract void alarm();

	protected abstract void stop();

	protected abstract void engineBoom();

	public void run() {
		for (Model model : seq) {
			if (model.equals(Model.START)){
				this.start();
			}else if (model.equals(Model.ALARM)){
				this.alarm();
			}else if (model.equals(Model.STOP)){
				this.stop();
			}else if (model.equals(Model.ENGINEBOOM)){
				this.engineBoom();
			}
		}
	}

}
