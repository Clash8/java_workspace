package com.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
             Statement stmt = conn.createStatement()) {

            // Create table
            stmt.execute("CREATE TABLE IF NOT EXISTS users (id INT PRIMARY KEY, name VARCHAR(255))");

            // Insert data
            stmt.execute("INSERT INTO users (id, name) VALUES (1, 'Alice'), (2, 'Bob')");

            // Query
            ResultSet rs = stmt.executeQuery("SELECT * FROM users");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " - " + rs.getString("name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}