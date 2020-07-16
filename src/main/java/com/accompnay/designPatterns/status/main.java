package com.accompnay.designPatterns.status;

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
