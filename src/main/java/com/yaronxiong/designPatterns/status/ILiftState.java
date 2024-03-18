package com.yaronxiong.designPatterns.status;

public abstract class ILiftState {
	protected Context context;

	public Context getContext() {
		return context;
	}

	public void setContext(Context context) {
		this.context = context;
	}

	public abstract void open();
	public abstract void close();
	public abstract void run();
	public abstract void stop();
}
