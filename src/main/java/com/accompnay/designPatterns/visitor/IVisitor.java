package com.accompnay.designPatterns.visitor;

public interface IVisitor {
	void visit(CommonEmployee commonEmployee);
	void visit(ManagerEmployee managerEmployee);
}
