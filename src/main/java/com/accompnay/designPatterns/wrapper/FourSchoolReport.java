package com.accompnay.designPatterns.wrapper;

public class FourSchoolReport implements SchoolReport {
	@Override
	public void report() {
		//成绩单的格式是这个样子的
		System.out.println("尊敬的XXX家长:");
		System.out.println(" ......");
		System.out.println(" 语文 62 数学65 体育 98 自然 63");
		System.out.println(" .......");
		System.out.println(" 家长签名： ");
	}

	//首先要定义你要美化的方法，先给老爸说学校最高成绩
	private void reportHighScore(){
		System.out.println("这次考试语文最高是75，数学是78，自然是80");
	}
	//在老爸看完毕成绩单后，我再汇报学校的排名情况
	private void reportSort(){
		System.out.println("我是排名第38名...");
	}

	@Override
	public void sign(String name) {
		System.out.println("家长签名为："+name);
	}
}
