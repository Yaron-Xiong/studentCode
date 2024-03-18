package com.yaronxiong.designPatterns.ChainofCommand;

public class HandlerFactory implements IHandlerFactory{
	@Override
	public Handler getHandler() {
		Handler fatherHandler = new FatherHandler();
		Handler husBandHandler = new HusBandHandler();
		Handler sonHandler = new SonHandler();
		fatherHandler.setNextHandler(husBandHandler);
		husBandHandler.setNextHandler(sonHandler);
		return fatherHandler;
	}
}
