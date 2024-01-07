package org.example.db;

import java.sql.SQLException;

public class Use {
    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAO();

        try {
            studentDAO.createTable();

            Student newStudent = new Student("Name Surname", 20);
            studentDAO.insertStudent(newStudent);

            for (Student student : studentDAO.getAllStudents()) {
                System.out.println("Student ID: " + student.getId() + ", Name: " + student.getName() + ", Age: " + student.getAge());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
