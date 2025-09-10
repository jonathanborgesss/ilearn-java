package com.mycompany.ilearn.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection instance;

    private static final String URL = "jdbc:mysql://localhost:3306/ilearn?useUnicode=true&characterEncoding=UTF-8";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private DBConnection() {}

    public static Connection getConnection() throws SQLException {
        if (instance == null || instance.isClosed()) {
            try {
                instance = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (SQLException e) {
                throw new SQLException("Erro ao conectar com o banco de dados", e);
            }
        }
        return instance;
    }
}
