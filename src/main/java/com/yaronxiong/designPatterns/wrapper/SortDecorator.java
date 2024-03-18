package com.yaronxiong.designPatterns.wrapper;

public class SortDecorator extends Decorator {

	public SortDecorator(SchoolReport schoolReport) {
		super(schoolReport);
	}

	//在老爸看完毕成绩单后，我再汇报学校的排名情况
	private void reportSort(){
		System.out.println("装饰器：我是排名第38名...");
	}

	@Override
	public void report() {
		reportSort();
		super.getSchoolReport().report();
	}
}
