package com.epsilon.training.entity;

public class Student extends Person {

	private int rollno;
	private String majorSubject;
	private double gpa;
	
	public Student() {
	}

	public Student(int rollno, String name, String email, String city, String majorSubject, double gpa) {
		super(name, email, city);
		this.rollno = rollno;
		this.majorSubject = majorSubject;
		this.gpa = gpa;
	}

	public int getRollno() {
		return rollno;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	public String getMajorSubject() {
		return majorSubject;
	}

	public void setMajorSubject(String majorSubject) {
		this.majorSubject = majorSubject;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", majorSubject=" + majorSubject + ", gpa=" + gpa + ", extends="
				+ super.toString() + "]";
	}
	
	@Override
	public void print() {
		System.out.println("Details of student: ");
		System.out.println("Roll no     : " + rollno);
		super.print();
		System.out.println("Major sub   : " + majorSubject);
		System.out.println("GPA         : " + gpa);
		
	}
	
	
}
