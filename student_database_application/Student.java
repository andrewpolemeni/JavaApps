package student_database_application;

import java.util.Scanner;

public class Student {
	private String firstName;
	private String lastName;
	private String gradeYear;
	private String studentId;
	private String courses;
	private int tuitionBalance = 0;
	private static int costOfCourse = 600;
	private static int id = 1000;
	
	// Constructor: prompt user to enter student's name and year
	public Student() {
		Scanner in = new Scanner(System.in);
		System.out.print("\nEnter student's first name: ");
		this.firstName = in.nextLine();
		
		System.out.print("Enter student's last name: ");
		this.lastName = in.nextLine();
		
		System.out.print("\nClass Levels:\n1) Freshman\n2) Sophmore\n3) Junior\n4) Senior\n\nEnter student class level:");
		this.gradeYear = in.nextLine();
		
		setStudentId();
	}
	
	// Generate an ID
	private void setStudentId() {
		// Grade Level + ID
		id++;
		this.studentId = gradeYear + "" + id;
	}
	
	// Enroll in courses
	public void enroll() {
		// Get inside a loop, user hits 0 
		do {
			System.out.println("Enter a course to enroll (Q to quit): ");
			Scanner in = new Scanner(System.in);
			String course = in.nextLine();
			if(!course.equals("Q")) {
				courses = courses + "\n" + course;
				tuitionBalance = tuitionBalance + costOfCourse;
			} else {
				break; 
			}
		} while (1 != 0);
	}
	
	// View balance
	public void viewBalance() {
		System.out.println("Your balance is: $" + tuitionBalance);
	}
	
	// Pay Tuition
	public void payTuition() {
		viewBalance();
		System.out.println("\nEnter your payment: $");
		Scanner in = new Scanner(System.in);
		int payment = in.nextInt();
		tuitionBalance = tuitionBalance - payment;
		System.out.println("\nThank you for your payment of: $" + payment);
		viewBalance();
	}
	
	// Show Status
	public String showInfo() {
		return "Name " + firstName + " " + lastName + 
				"\nGrade Level: " + gradeYear + 
				"\nStudent ID: " + studentId + 
				"\nCourses Enrolled: \n" + courses + 
				"\nBalance: $" + tuitionBalance;
	}
	
}
