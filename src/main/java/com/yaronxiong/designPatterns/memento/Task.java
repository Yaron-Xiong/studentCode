package com.yaronxiong.designPatterns.memento;

public class Task implements Cloneable {

	private String status;


	private Caretaker caretaker = new Caretaker();

	public Task() {
		status = "初始化";
	}

	public Task(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void createMemento() {
		this.caretaker.addMemento((Task) clone());
	}

	public void reloadLast() {
		//这一步可以用Spring的BeanUtils的方法
		this.status = this.caretaker.getLastMemento().status;
	}

	@Override
	public Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException("克隆失败");
		}
	}

	@Override
	public String toString() {
		return "Task{" +
				"status='" + status + '\'' +
				'}';
	}
}
