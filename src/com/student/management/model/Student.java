package com.student.management.model;

public class Student {
	private int id;
	private String name;
	private double marks;

	public Student() {

	}

	public Student(int id, String name, double marks) {
		this.id = id;
		this.name = name;
		this.marks = marks;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setMarks(double marks) {
		this.marks = marks;
	}

	public double getMarks() {
		return marks;
	}

	@Override
	public String toString() {
		return "[ Student ID: " + id + " Name: " + name + " Marks: " + marks + " ]";
	}

}
