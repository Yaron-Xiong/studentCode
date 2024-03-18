package com.yaronxiong.designPatterns.factory.simple;

/**
 * 人类的共性抽取，具体的实现由子类实现
 */
public interface Human {
	void getColor();
	void talk();
}
