package com.yaronxiong.designPatterns.visitor;

public class Visitor implements IVisitor {
	@Override
	public void visit(CommonEmployee commonEmployee) {
		String commonInfo = getCommonInfo(commonEmployee);
		System.out.println(commonInfo);
	}

	@Override
	public void visit(ManagerEmployee managerEmployee) {
		String managerInfo = getManagerInfo(managerEmployee);
		System.out.println(managerInfo);
	}

	public String getBaseInfo(Employee employee) {
		String info = "姓名：" + employee.getName() + "\t";
		info = info + "性别：" + (employee.getSex() == Employee.FEMALE ? "女" : "男") + "\t";
		info = info + "薪水：" + employee.getSalary() + "\t";
		return info;
	}

	public String getCommonInfo(CommonEmployee commonEmployee) {
		return getBaseInfo(commonEmployee) + "工作" + commonEmployee.getJobName() + "\t";
	}

	public String getManagerInfo(ManagerEmployee managerEmployee) {
		return getBaseInfo(managerEmployee) + "业绩" + managerEmployee.getPerformance() + "\t";
	}
}
