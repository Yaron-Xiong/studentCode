package com.yaronxiong.designPatterns.build;

import java.util.List;

public abstract class CarBuilder {
	private List<Model> seqList;
	public abstract CarModel build();

	public void setSeqList(List<Model> seqList) {
		this.seqList = seqList;
	}

	protected List<Model> getSeqList() {
		return seqList;
	}
}
