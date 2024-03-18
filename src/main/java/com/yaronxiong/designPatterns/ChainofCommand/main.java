package com.yaronxiong.designPatterns.ChainofCommand;

import java.util.Random;

/**
 * PS：设计模式多层嵌套，能够看到很不错的效果，例如下方使用了 责任链模式 + 工厂模式
 * 责任链模式：
 * 存在一条单项链表，请求从链头进入，可以从某个节点退出。每个节点有自己独属的处理方式
 * 例如古代存在三从四德，三从 从夫 从夫 从子，如果女人要出门
 * 未出阁 需要得到父亲的同意
 * 结婚 需要得到丈夫的同意
 * 寡妇 需要得到儿子的同意
 * 丧子 需要得到叔伯的同意
 * ...
 * 那么如何通过代码编写？一直写if？没出一个节点就要加一个if？
 * 那么责任链的机制就是将每个节点串联起来形成一条链，请求从父亲开始，如果没有父亲则将请求一直向下发送
 * 直到有一个人同意。则结束

 */
public class main {
	public static void main(String[] args) {
		IHandlerFactory handlerFactory = new HandlerFactory();
		Handler handler = handlerFactory.getHandler();
		Random random = new Random();
		for (int i = 0; i < 100; i++) {
			IWoman woman = new Woman((random.nextInt(4)), i+"我想上街买衣服");
			handler.hand(woman);
		}
	}
}
