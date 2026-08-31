package com.expensetracker.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL =
            "jdbc:mysql://localhost:3306/business_expenses_tracker";

    private static final String USERNAME = "root";

    private static final String PASSWORD = "sneha@123";

    public static Connection getConnection() {

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(
                    URL,
                    USERNAME,
                    PASSWORD
            );

            System.out.println("Database connected successfully!");

        } catch (SQLException e) {
            System.out.println("Database connection failed!");
            e.printStackTrace();
        }

        return connection;
    }
}