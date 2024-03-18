package com.yaronxiong.designPatterns.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * 访问者模式
 */
public class main {
	public static void main(String[] args) {
		Visitor visitor = new Visitor();
		for (Employee employee : mockEmployee()) {
			employee.accept(visitor);
			employee.report();
		}
	}

	public static List<Employee> mockEmployee() {
		List<Employee> empList = new ArrayList<>();
		//产生张三这个员工
		CommonEmployee zhangSan = new CommonEmployee();
		zhangSan.setJobName("编写Java程序，绝对的蓝领、苦工加搬运工");
		zhangSan.setName("张三");
		zhangSan.setSalary(1800);
		zhangSan.setSex(Employee.MALE);
		empList.add(zhangSan);
		//产生李四这个员工
		CommonEmployee liSi = new CommonEmployee();
		liSi.setJobName("页面美工，审美素质太不流行了！");
		liSi.setName("李四");
		liSi.setSalary(1900);
		liSi.setSex(Employee.FEMALE);
		empList.add(liSi);
		//再产生一个经理
		ManagerEmployee wangWu = new ManagerEmployee();
		wangWu.setName("王五");
		wangWu.setPerformance("基本上是负值，但是我会拍马屁呀");
		wangWu.setSalary(18750);
		wangWu.setSex(Employee.MALE);
		empList.add(wangWu);
		return empList;
	}

}
