package com.studentmanagement.dao;

import com.studentmanagement.model.Student;
import com.studentmanagement.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    // ADD STUDENT
    public void addStudent(Student student) throws SQLException {

        String sql = "INSERT INTO students(name, age, department, email) VALUES (?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, student.getName());
            ps.setInt(2, student.getAge());
            ps.setString(3, student.getDepartment());
            ps.setString(4, student.getEmail());

            ps.executeUpdate();
        }
    }

    // VIEW STUDENTS
    public List<Student> getAllStudents() throws SQLException {

        List<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM students";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Student s = new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("department"),
                        rs.getString("email")
                );
                list.add(s);
            }
        }

        return list;
    }

    // UPDATE STUDENT
    public void updateStudent(Student student) throws SQLException {

        String sql = "UPDATE students SET department=?, email=? WHERE id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, student.getDepartment());
            ps.setString(2, student.getEmail());
            ps.setInt(3, student.getId());

            ps.executeUpdate();
        }
    }

    // DELETE STUDENT
    public void deleteStudent(int id) throws SQLException {

        String sql = "DELETE FROM students WHERE id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}