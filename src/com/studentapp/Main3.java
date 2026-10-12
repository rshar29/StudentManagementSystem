package com.studentapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main3 {
	private static List<Student> studentList;
	private static Scanner scanner;

	public static void main(String[] args) {
		System.out.println("*****************Student Management System************");

		studentList = new ArrayList<>();
		Scanner scanner=new Scanner(System.in);
		
		while(true) {
		System.out.println("*********Welcome**********");
		System.out.println("Select an Option...");
		System.out.println("1. Register a Student...");
		System.out.println("2. Find Student with StudentId...");
		System.out.println("3. List All Student Information...");
		System.out.println("4. List Student Information in sorted Order...");
		System.out.println("5. Exit...");
		
		int option=scanner.nextInt();
		switch(option) {
		
		case 1:
			endrollStudent(scanner);
			break;
			
		case 2: 
			findStudentById(scanner);
		break;
		
		case 3:
			printAllStudentData();
			break;
			
		case 4:
			sortByName(); break;
			
		case 5:
			exit(); break;
			
			default: System.out.println("Invalid option selected!!! Please select between 1 to 5..");
		}
		}
	}

	private static void findStudentById(Scanner scanner2) {
		
		Student studentFound = null;
		System.out.println("Enter the student Id");
		String studentId=scanner2.next();

		try {
			studentFound = studentList.stream().filter(x -> x.getStudentId().equalsIgnoreCase(studentId)).findFirst()
					.orElseThrow(() -> new RuntimeException("No data found"));
		} catch (RuntimeException e) {
			System.err.println("Student with ID " + studentId + " not found!!");
		}
		studentFound.printStudentInfo();
	}

	private static void exit() {
		System.out.println("Good Bye,,");
		System.exit(0);
	}

	private static void printAllStudentData() {
		System.out.println("----------------Printing all student Data----------------");
		if(studentList.size()>0) {
		for (Student student : studentList) {
			student.printStudentInfo();
		}
		System.out.println("----------------******************----------------");
		
	}else {
		System.out.println("Student list is empty!!! No student record found..");
	}
	}

	private static void endrollStudent(Scanner scanner2) {
		
		System.out.println("Enter the Student Name..");
		String studentName=scanner2.next();
		
		System.out.println("Enter the Student Age..");
		int studentAge=scanner2.nextInt();
		
		System.out.println("Enter the Student Id..");
		String studentId=scanner2.next();
		
		Student newStudent=new Student(studentName,studentAge,studentId);
		studentList.add(newStudent);
		
		while(true) {
		System.out.println("Enter the course to be entrolled...Type Done tp exit");
		String courseName=scanner2.next();
		if(courseName.equalsIgnoreCase("Done")) {
			break;
		}
		newStudent.endrollCourse(courseName);
		}
		newStudent.printStudentInfo();
	}

	public static Student findStudentById(String StudentId) {
		Student result = null;

		try {
			result = studentList.stream().filter(x -> x.getStudentId().equalsIgnoreCase(StudentId)).findFirst()
					.orElseThrow(() -> new RuntimeException("No data found"));
		} catch (RuntimeException e) {
			System.err.println("Student with ID " + StudentId + " not found!!");
		}
		return result;

	}

	private static void sortByName() {
		Comparator<Student> studentNameComparator=(o1,o2) ->o1.getName().compareTo(o2.getName());
		Collections.sort(studentList, studentNameComparator);
		printAllStudentData();
	}
}
