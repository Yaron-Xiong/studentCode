package com.accompnay.designPatterns.status;

public class CloseLiftState extends ILiftState {
	@Override
	public void open() {
		super.context.setCurStatus(Context.openListStatus);
		super.context.open();
	}

	@Override
	public void close() {
		System.out.println("电梯门关闭");
	}

	@Override
	public void run() {
		super.context.setCurStatus(Context.runLiftStatus);
		super.context.run();
	}

	@Override
	public void stop() {
		throw new RuntimeException("开着的门不能停止");
	}
}
