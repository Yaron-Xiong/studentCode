package com.yaronxiong.designPatterns.wrapper;

/**
 * 继承不推荐，会导致类会随着需求变化不断的膨胀。
 * 可以加入一个新的结构来完成对原有类的增强
 */
public class SugarFourSchoolReport extends FourSchoolReport {

	//首先要定义你要美化的方法，先给老爸说学校最高成绩
	private void reportHighScore(){
		System.out.println("这次考试语文最高是75，数学是78，自然是80");
	}
	//在老爸看完毕成绩单后，我再汇报学校的排名情况
	private void reportSort(){
		System.out.println("我是排名第38名...");
	}

	@Override
	public void report() {
		//对原有方法进行增强
		reportHighScore();
		super.report();
		reportSort();
	}

	@Override
	public void sign(String name) {
		super.sign(name);
	}
}
