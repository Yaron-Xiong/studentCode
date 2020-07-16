package com.accompnay.designPatterns.abstractP;

public abstract class HummerModel {

	/**
	 * 是否开启喇叭，默认为false
	 */
	private boolean isAlarm ;

	/**
	 * 启动车辆
	 */
	protected abstract void start();

	/**
	 * 停止
	 */
	protected abstract void stop();

	/**
	 * 喇叭
	 */
	protected abstract void alarm();

	/**
	 * 引擎
	 */
	protected abstract void engineBoom();

	/**
	 * 钩子函数，决定是否开喇叭
	 */
	protected void setAlarm(boolean isAlarm) {
		this.isAlarm = isAlarm;
	}

	/**
	 * 启动
	 */
	public void run(){
		this.start();
		this.engineBoom();
		if (isAlarm){
			this.alarm();
		}
		this.stop();
	}
}
