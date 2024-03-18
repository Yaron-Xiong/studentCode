package com.yaronxiong.designPatterns.command;

public class AddCommand extends Command{
	@Override
	public void execute() {
		Group requirementGroup = getRequirementGroup();
		Group pageGroup = getPageGroup();
		Group codeGroup = getCodeGroup();
		requirementGroup.find();
		requirementGroup.add();
		requirementGroup.plan();
		pageGroup.find();
		codeGroup.find();
		pageGroup.add();
		codeGroup.add();
		pageGroup.plan();
		codeGroup.plan();
	}
}
