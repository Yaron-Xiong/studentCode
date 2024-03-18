package com.yaronxiong.designPatterns.visitor;

public class CommonEmployee extends Employee {

	private String jobName;

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	@Override
	public void report() {
		getVisitor().visit(this);
	}
}
