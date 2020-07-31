package com.accompnay.designPatterns.visitor;

public class ManagerEmployee extends Employee {

	private String performance;

	public String getPerformance() {
		return performance;
	}

	public void setPerformance(String performance) {
		this.performance = performance;
	}

	@Override
	public void report() {
		getVisitor().visit(this);
	}
}
