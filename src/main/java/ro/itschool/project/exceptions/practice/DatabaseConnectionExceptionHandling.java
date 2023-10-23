package ro.itschool.project.exceptions.practice;

import java.sql.*;

public class DatabaseConnectionExceptionHandling {

    public static void main(String[] args) {
        String databaseUrl = "jdbc:postgresql://localhost:5432/test_database";
        String user = "developer";
        String password = "developer";

        try (Connection connection = DriverManager.getConnection(databaseUrl, user, password)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
        } catch (SQLException exception) {
            System.out.println("Something went wrong.");
        }
    }
}