package com.studentapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
	static List<Student> studentList;

	public static void main(String[] args) {
		System.out.println("*****************Student Management System************");
		System.out.println("*********Welcome**********");

		studentList = new ArrayList<>();

		Student stu1 = new Student("Rakesh Sharma", 20, "S-11");

		stu1.endrollCourse("java");
		stu1.endrollCourse("DSA");
		stu1.endrollCourse("Python");
		stu1.endrollCourse("C#");

		// System.out.println(stu1);
		// stu1.printStudentInfo();

		Student stu2 = new Student("Soni Sharma", 19, "S-12");
		stu2.endrollCourse("java");

		Student stu3 = new Student("Ritu", 19, "S-13");
		stu3.endrollCourse("Python");

		Student stu4 = new Student("Aman", 19, "S-13");
		stu3.endrollCourse("Python");

		studentList.add(stu1);
		studentList.add(stu2);
		studentList.add(stu3);
		studentList.add(stu4);

		Student result = findStudentById("S-11");
		System.out.println("Result " + result);
		sortByName();
	}

	public static Student findStudentById(String studentId) {
		Student result = null;

		try {
			result = studentList.stream().filter(x -> x.getStudentId().equalsIgnoreCase(studentId)).findFirst()
					.orElseThrow(() -> new RuntimeException("No data found"));
		} catch (RuntimeException e) {
			System.err.println("Student with ID " + studentId + " not found!!");
		}
		return result;

	}

	private static void sortByName() {
		Comparator<Student> studentNameComparator = new Comparator<Student>() {
        //Comparator<Student> studentNameComparator=(o1,o2) ->o1.getName().compareTo(o2.getName());
			@Override
			public int compare(Student o1, Student o2) {
				return o1.getName().compareTo(o2.getName()); // Compare Lexographically
			}
		};
		Collections.sort(studentList, studentNameComparator);
		System.out.println(studentList);
	}
}
