package com.studentapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main2 {
	static List<Student> studentList;

	public static void main(String[] args) {
		System.out.println("*****************Student Management System************");
		System.out.println("*********Welcome**********");

		studentList = new ArrayList<>();
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter student name...");
		String stuName=scanner.next();
		System.out.println("You have entered the name: "+stuName);
		
		System.out.println("Enter student age...");
		int stuAge=scanner.nextInt();
		System.out.println("You have entered the age: "+stuAge);
		
		System.out.println("Enter student Student Id...");
		int stuId=scanner.nextInt();
		System.out.println("You have entered the Student Id: "+stuId);

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
