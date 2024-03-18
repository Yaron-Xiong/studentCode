package com.yaronxiong.designPatterns.visitor;

public interface IVisitor {
	void visit(CommonEmployee commonEmployee);
	void visit(ManagerEmployee managerEmployee);
}
