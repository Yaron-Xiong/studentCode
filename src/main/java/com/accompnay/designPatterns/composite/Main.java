package com.accompnay.designPatterns.composite;

/**
 * 组合模式 composite
 */
public class Main {
	public static void main(String[] args) {
		Manager manager = new Manager("王大麻子",100000,"总经理");


		Manager manager2 = new Manager("刘大瘸子",20000,"财务部经理");
		Manager manager3 = new Manager("马二拐子",30000,"销售部门经理");
		Manager manager4 = new Manager("赵三驼子",40000,"研发总经理");


		Manager manager5 = new Manager("杨三乜斜",40000,"开发一组组长");
		Manager manager6 = new Manager("吴大棒槌",40000,"开发二组组长");


		Staff staff = new Staff("a",40000,"研发小弟");
		Staff staff1 = new Staff("b",40000,"研发小弟");
		Staff staff2 = new Staff("c",40000,"研发小弟");
		Staff staff4 = new Staff("d",40000,"研发小弟");
		Staff staff3 = new Staff("e",40000,"研发小弟");
		Staff staff5 = new Staff("f",40000,"研发小弟");
		Staff staff6 = new Staff("g",40000,"研发小弟");
		Staff staff7 = new Staff("h",40000,"研发小弟");
		Staff staff8 = new Staff("i",40000,"研发小弟");
		Staff staff9 = new Staff("j",40000,"研发小弟");

		manager.addSubNode(manager2).addSubNode(manager3).addSubNode(manager4);
		manager4.addSubNode(manager5).addSubNode(manager6);
		manager6.addSubNode(staff)
				.addSubNode(staff1)
				.addSubNode(staff2)
				.addSubNode(staff4)
				.addSubNode(staff3)
				.addSubNode(staff5)
				.addSubNode(staff6)
				.addSubNode(staff7)
				.addSubNode(staff8)
				.addSubNode(staff9);
		getAll(manager);
	}

	private static void getAll(AbstractNode root) {
		root.getInfo();
		for (AbstractNode node : root.getSubNode()) {
			getAll(node);
		}
	}
}
