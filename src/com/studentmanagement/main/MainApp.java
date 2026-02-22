package com.studentmanagement.main;

import com.studentmanagement.dao.StudentDAO;
import com.studentmanagement.model.Student;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentDAO studentDAO = new StudentDAO();

        while (true) {

            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            try {

                switch (choice) {

                    case 1:
                        sc.nextLine();
                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Age: ");
                        int age = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Department: ");
                        String dept = sc.nextLine();

                        System.out.print("Enter Email: ");
                        String email = sc.nextLine();

                        Student student = new Student(name, age, dept, email);

                        studentDAO.addStudent(student);   // ✅ You forgot this
                        System.out.println("✅ Student Added Successfully");
                        break;

                    case 2:
                        List<Student> students = studentDAO.getAllStudents();

                        System.out.println("--- Student List ---");
                        for (Student s : students) {
                            System.out.println(
                                    s.getId() + " | " +
                                            s.getName() + " | " +
                                            s.getAge() + " | " +
                                            s.getDepartment() + " | " +
                                            s.getEmail()
                            );
                        }
                        break;

                    case 3:
                        System.out.print("Enter Student ID to update: ");
                        int updateId = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter New Department: ");
                        String newDept = sc.nextLine();

                        System.out.print("Enter New Email: ");
                        String newEmail = sc.nextLine();

                        Student updatedStudent =
                                new Student(updateId, null, 0, newDept, newEmail);

                        studentDAO.updateStudent(updatedStudent);
                        System.out.println("✅ Student updated successfully!");
                        break;

                    case 4:
                        System.out.print("Enter Student ID to delete: ");
                        int deleteId = sc.nextInt();

                        studentDAO.deleteStudent(deleteId);
                        System.out.println("❌ Student deleted successfully!");
                        break;

                    case 5:
                        System.out.println("Exiting...");
                        sc.close();
                        System.exit(0);

                    default:
                        System.out.println("❌ Invalid choice!");
                }

            } catch (SQLException e) {
                System.out.println("⚠ Database Error: " + e.getMessage());
            }
        }
    }
}