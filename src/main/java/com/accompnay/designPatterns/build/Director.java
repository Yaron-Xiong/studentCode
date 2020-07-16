package com.accompnay.designPatterns.build;

import com.google.common.collect.Lists;

import java.util.List;

public class Director {

	public BenzModel buildBenzModel(){
		List<Model> models = Lists.newArrayList(Model.START, Model.ENGINEBOOM, Model.ALARM, Model.STOP);
		BenzCarBuilder builder = new BenzCarBuilder();
		builder.setSeqList(models);
		return (BenzModel) builder.build();
	}
}
