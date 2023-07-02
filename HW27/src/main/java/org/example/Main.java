package org.example;

import org.hibernate.SessionFactory;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateSession.getSessionFactory();

        StudentDAO studentDAO = new StudentDAO(sessionFactory);

        Student student1 = new Student();
        student1.setName("Bohdan K");
        student1.setEmail("jbodh@example.com");
        studentDAO.addStudent(student1);

        Student studentToUpdate = studentDAO.getStudentById(1L);
        if (studentToUpdate != null) {
            studentToUpdate.setName("Updated Name");
            studentDAO.updateStudent(studentToUpdate);
        }
        Student studentToDelete = studentDAO.getStudentById(1L);
        if (studentToDelete != null) {
            studentDAO.deleteStudent(studentToDelete);
        }
        List<Student> students = studentDAO.getAllStudents();
        for (Student student : students) {
            System.out.println("Student: " + student.getName() + ", Email: " + student.getEmail());
        }

        sessionFactory.close();
    }
}
