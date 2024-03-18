package com.yaronxiong.designPatterns.wrapper;

public abstract class Decorator {
	private SchoolReport schoolReport;

	public Decorator(SchoolReport schoolReport) {
		this.schoolReport = schoolReport;
	}

	/**
	 * 需要增强的方法
	 */
	public abstract void report();

	public void sign(String name){
		schoolReport.sign(name);
	}

	public SchoolReport getSchoolReport() {
		return schoolReport;
	}

	public void setSchoolReport(SchoolReport schoolReport) {
		this.schoolReport = schoolReport;
	}
}
