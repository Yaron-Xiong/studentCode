package com.accompnay.designPatterns.command;

public abstract class Command {

	private Group codeGroup = new CodeGroup();

	private Group pageGroup = new PageGroup();

	private Group requirementGroup = new RequiremntGroup();

	public abstract void execute();

	protected Group getCodeGroup() {
		return codeGroup;
	}

	protected Group getPageGroup() {
		return pageGroup;
	}

	protected Group getRequirementGroup() {
		return requirementGroup;
	}
}
