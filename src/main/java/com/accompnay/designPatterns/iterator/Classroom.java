package com.accompnay.designPatterns.iterator;

import com.google.common.collect.Lists;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

public class Classroom implements Iterable<Student> {

	private List<Student> studentList;
	private String name;
	private int modCount;
	public Classroom(String name) {
		this.name = name;
		this.studentList = Lists.newArrayList();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addStudent(Student student) {
		modCount++;
		studentList.add(student);
	}

	@Override
	public Iterator<Student> iterator() {
		return new Itr();
	}

	class Itr implements Iterator<Student> {

		private int index;
		private int mod;
		public Itr() {
			mod = modCount;
		}

		@Override
		public boolean hasNext() {
			checkMod();
			return studentList.size() > index;
		}

		@Override
		public Student next() {
			checkMod();
			return studentList.get(index++);
		}

		private void checkMod() {
			if (mod != modCount) {
				throw new ConcurrentModificationException("不能再遍历过程中对原集合操作");
			}
		}

		@Override
		public void remove() {
			checkMod();
			studentList.remove(--index);
		}

	}
}
