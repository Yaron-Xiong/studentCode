package com.yaronxiong.designPatterns.status;

public class OpenLiftState extends ILiftState {
	@Override
	public void open() {
		System.out.println("电梯门开启");
	}

	@Override
	public void close() {
		super.context.setCurStatus(Context.closeLiftStatus);
		super.context.close();
	}

	@Override
	public void run() {
		throw new RuntimeException("开着的门不能启动电梯");
	}

	@Override
	public void stop() {
		super.context.setCurStatus(Context.stopLiftStatus);
		super.context.stop();
	}
}
