package com.pkproject.internetcourse.application.datebase;


import java.sql.*;

/**
 * Created by dominikzaq on 12.12.2016.
 */
public class DBConnect {
    String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    String DB_URL = "jdbc:mysql://localhost/";
    String USER = "root";
    String PASS = "";
    private Connection connection;
    public Connection getConnection() {
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Too Many Connection");
        }

        return connection;
    }
}
