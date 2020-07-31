package com.accompnay.designPatterns.status;

/**
 * 状态设计模式
 */
public class main {
	public static void main(String[] args) {
		Context context = new Context();
		context.setCurStatus(Context.closeLiftStatus);
		context.open();
		context.close();
		context.run();
		context.stop();
	}
}
