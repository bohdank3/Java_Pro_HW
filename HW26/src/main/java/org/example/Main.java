package org.example;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DataBaseConnection dbConnection = new DataBaseConnection();

        LessonDao lessonDao = new LessonDao(dbConnection);

        Homework homework = new Homework(1, "Homework 1", "Description 1");
        Lesson lesson = new Lesson(1, "Lesson 1", homework);
        lessonDao.addLesson(lesson);

        List<Lesson> lessons = lessonDao.getAllLessons();
        for (Lesson l : lessons) {
            System.out.println("Lesson ID: " + l.getId());
            System.out.println("Lesson Name: " + l.getName());
            System.out.println("Homework ID: " + l.getHomework().getId());
            System.out.println("Homework Name: " + l.getHomework().getName());
            System.out.println("Homework Description: " + l.getHomework().getDescription());
            System.out.println("-----------------------");
        }

        Lesson lessonById = lessonDao.getLessonById(1);
        if (lessonById != null) {
            System.out.println("Lesson ID: " + lessonById.getId());
            System.out.println("Lesson Name: " + lessonById.getName());
            System.out.println("Homework ID: " + lessonById.getHomework().getId());
            System.out.println("Homework Name: " + lessonById.getHomework().getName());
            System.out.println("Homework Description: " + lessonById.getHomework().getDescription());
        } else {
            System.out.println("Lesson not found!");
        }

        lessonDao.deleteLesson(1);

        try {
            dbConnection.close(dbConnection.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}