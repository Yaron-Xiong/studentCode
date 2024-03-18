package com.yaronxiong.designPatterns.wrapper;

public class HighDecorator extends Decorator {

	public HighDecorator(SchoolReport schoolReport) {
		super(schoolReport);
	}

	//首先要定义你要美化的方法，先给老爸说学校最高成绩
	private void reportHighScore(){
		System.out.println("装饰器：这次考试语文最高是75，数学是78，自然是80");
	}

	@Override
	public void report() {
		reportHighScore();
		super.getSchoolReport().report();
	}
}
