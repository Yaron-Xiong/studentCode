package com.yaronxiong.designPatterns.status;

public class RunLiftState extends ILiftState {
	@Override
	public void open() {
		throw new RuntimeException("开着的电梯不能开门");
	}

	@Override
	public void close() {
		throw new RuntimeException("开着的电梯不能关门");
	}

	@Override
	public void run() {
		System.out.println("正在运行");
	}

	@Override
	public void stop() {
		super.context.setCurStatus(Context.stopLiftStatus);
		super.context.stop();
	}
}
