package com.accompnay.designPatterns.status;

public class StopLiftState extends ILiftState {
	@Override
	public void open() {
		super.context.setCurStatus(Context.openListStatus);
		super.context.open();
	}

	@Override
	public void close() {
		throw new RuntimeException("开着的电梯不能开门");
	}

	@Override
	public void run() {
		super.context.setCurStatus(Context.runLiftStatus);
		super.context.run();
	}

	@Override
	public void stop() {
		System.out.println("正在停止");
	}
}
