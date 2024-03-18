package com.yaronxiong.designPatterns.status;

public class Context {
	public static final ILiftState openListStatus = new OpenLiftState();
	public static final ILiftState stopLiftStatus = new StopLiftState();
	public static final ILiftState runLiftStatus = new RunLiftState();
	public static final ILiftState closeLiftStatus = new CloseLiftState();

	private ILiftState curStatus;

	public void setCurStatus(ILiftState curStatus) {
		this.curStatus = curStatus;
		this.curStatus.setContext(this);
	}

	public void open(){
		curStatus.open();
	}

	public void stop(){
		curStatus.stop();
	}

	public void run(){
		curStatus.run();
	}

	public void close(){
		curStatus.close();
	}

}
