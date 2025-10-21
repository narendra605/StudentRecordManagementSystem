package com.student.management.main;

import java.util.*;
import com.student.management.model.Student;

public class StudentManagementSystem {

    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("===== Welcome to Student Record Management System =====");

        while (true) {
            System.out.println("\n1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                addStudent();
            } else if (choice == 2) {
                viewStudents();
            } else if (choice == 3) {
                updateStudent();
            } else if (choice == 4) {
                deleteStudent();
            } else if (choice == 5) {
                System.out.println("Exiting... Thank you!");
                break;
            } else {
                System.out.println("Invalid choice! Please enter a valid option.");
            }
        }
    }

    // Method to add a new student
    private static void addStudent() {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // consume newline
        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();

        Student student = new Student(id, name, marks);
        students.add(student);

        System.out.println("✅ Student added successfully!");
    }

    // Method to view all students
    private static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("⚠️ No student records found.");
        } else {
            System.out.println("\n--- Student Records ---");
            for (Student s : students) {
                System.out.println(s);
            }
        }
    }

    // Method to update a student by ID
    private static void updateStudent() {
        System.out.print("Enter the ID of the student to update: ");
        int id = sc.nextInt();
        sc.nextLine(); // consume newline

        boolean found = false;
        for (Student s : students) {
            if (s.getId() == id) {
                System.out.print("Enter new name: ");
                String newName = sc.nextLine();
                System.out.print("Enter new marks: ");
                double newMarks = sc.nextDouble();

                s.setName(newName);
                s.setMarks(newMarks);
                System.out.println("✅ Student details updated successfully!");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("❌ Student with ID " + id + " not found.");
        }
    }

    // Method to delete a student by ID
    private static void deleteStudent() {
        System.out.print("Enter the ID of the student to delete: ");
        int id = sc.nextInt();

        Iterator<Student> iterator = students.iterator();
        boolean found = false;

        while (iterator.hasNext()) {
            Student s = iterator.next();
            if (s.getId() == id) {
                iterator.remove();
                System.out.println("✅ Student deleted successfully!");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("❌ Student with ID " + id + " not found.");
        }
    }
}
