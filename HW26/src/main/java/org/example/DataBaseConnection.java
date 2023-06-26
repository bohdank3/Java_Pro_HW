package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/study";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";


    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public void close(Connection connection) throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }
}
