package com.yaronxiong.designPatterns.iterator;


import java.util.Iterator;

public class main {
	public static void main(String[] args) {
		Classroom classroom = new Classroom("高一三班");
		Student student = new Student("张三", 15);
		Student student2 = new Student("张三2", 15);
		Student student3 = new Student("张三3", 15);
		Student student4 = new Student("张三4", 15);
		Student student5 = new Student("张三5", 15);
		Student student6 = new Student("张三6", 15);
		Student student7 = new Student("张三7", 15);

		classroom.addStudent(student);
		classroom.addStudent(student2);
		classroom.addStudent(student3);
		classroom.addStudent(student4);
		classroom.addStudent(student5);
		classroom.addStudent(student6);
		classroom.addStudent(student7);

		Iterator<Student> iterator = classroom.iterator();
		while (iterator.hasNext()) {
			Student next = iterator.next();
			if (next.getName().equals("张三2")) {
				iterator.remove();
			}
		}
		for (Student rs : classroom) {
			System.out.println(rs);
		}
		
	}
}
