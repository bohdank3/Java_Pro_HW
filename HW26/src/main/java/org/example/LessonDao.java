package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LessonDao {
    private DataBaseConnection dbConnection;

    public LessonDao(DataBaseConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    public void addLesson(Lesson lesson) {
        try (Connection connection = dbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO Lesson (name, updatedAt, homework_id) VALUES (?, ?, ?)"
             )) {
            statement.setString(1, lesson.getName());
            statement.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
            statement.setInt(3, lesson.getHomework().getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteLesson(int lessonId) {
        try (Connection connection = dbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "DELETE FROM Lesson WHERE id = ?"
             )) {
            statement.setInt(1, lessonId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Lesson> getAllLessons() {
        List<Lesson> lessons = new ArrayList<>();
        try (Connection connection = dbConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM Lesson")) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int homeworkId = resultSet.getInt("homework_id");
                Homework homework = getHomeworkById(homeworkId);
                Lesson lesson = new Lesson(id, name, homework);
                lessons.add(lesson);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lessons;
    }

    public Lesson getLessonById(int lessonId) {
        try (Connection connection = dbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT * FROM Lesson WHERE id = ?"
             )) {
            statement.setInt(1, lessonId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    int homeworkId = resultSet.getInt("homework_id");
                    Homework homework = getHomeworkById(homeworkId);
                    return new Lesson(id, name, homework);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Homework getHomeworkById(int homeworkId) {
        try (Connection connection = dbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT * FROM Homework WHERE id = ?"
             )) {
            statement.setInt(1, homeworkId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String description = resultSet.getString("description");
                    return new Homework(id, name, description);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}