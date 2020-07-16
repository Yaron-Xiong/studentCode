package com.accompnay.designPatterns.command;

public interface Group {

	/**
	 * 查找组
	 */
	void find();

	/**
	 * 添加需求
	 */
	void add();

	/**
	 * 删除需求
	 */
	void del();

	/**
	 * 变更需求
	 */
	void plan();
}
