package com.studentapp;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {
	private String name;
	private int age;
	private String studentId;
	List<String> courses;

	public Student(String name, int age, String studentId) {
		super();
		if (validateAge(age) && validateName(name) && validateStudentId(studentId)) {
			this.name = name;
			this.age = age;
			this.studentId = studentId;
			courses = new ArrayList<String>(); // initialization of courses
		}
	}

	public void endrollCourse(String course) {

		if (validateCourseName(course)) {

			if (!courses.contains(course)) {
				courses.add(course);
				System.err.println("Student is endrolled to this course " + course);
			} else {
				System.out.println("Student is already endrolled to " + course);
			}
		}
	}

	public void printStudentInfo() {
		System.out.println("===========Student information===========");
		System.out.println("Student Name: " + name);
		System.out.println("Student Age: " + age);
		System.out.println("Student Id: " + studentId);
		System.out.println("Endrolled for: " + courses);
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", studentId=" + studentId + ", courses=" + courses + "]";
	}

	// validation method for age
	public boolean validateAge(int age) {
		if (age >= 18 && age <= 35) {
			return true;
		} else {
			System.out.println("Invalid age!!! Student age should be b/w 18 to 35");
			return false;
		}

	}

	// Validation for name
	public boolean validateName(String name) {

		String nameRegex = "^[a-zA-Z\\s]+$";
		Pattern namePattern = Pattern.compile(nameRegex);
		Matcher nameMather = namePattern.matcher(name);

		if (nameMather.matches()) {
			return true;
		} else {
			System.err.println("Invalid Name!!  Please enter alphabetes only.");
			return false;
		}

	}

	private boolean validateStudentId(String studentId) {
		// String studentRegex= "S-[0-9]+$"; //S-123
		String studentRegex = "S-\\d+$"; // S-123

		Pattern studentIdPattern = Pattern.compile(studentRegex);
		Matcher studentIdMatcher = studentIdPattern.matcher(studentId);

		if (studentIdMatcher.matches()) {
			return true;
		} else {
			System.err.println("Invalid Student Id !!! Use as the format ex: S-123");
		}

		return false;
	}

	public boolean validateCourseName(String course) {

		if (course.equalsIgnoreCase("Java") || course.equalsIgnoreCase("DSA") || course.equalsIgnoreCase("Python")) {
			return true;
		} else {
			System.err.println("Invalid Course name !!! Please select Courses from the list!! [Java, DSA, Python]");
		}
		return false;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getStudentId() {
		return studentId;
	}

	public List<String> getCourses() {
		return courses;
	}

}
