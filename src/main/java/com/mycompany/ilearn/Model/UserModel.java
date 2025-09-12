package com.mycompany.ilearn.Model;

import com.mycompany.ilearn.Util.DBConnection;
import java.sql.*;

public class UserModel {
    private String email;
    private String username;
    private String password;

    public UserModel() {
        // default constructor
    }

    public UserModel(String email, String username) {
        this.email = email;
        this.username = username;
    }

    public boolean authenticate(String email, String password) {
        String sql = "SELECT * FROM user WHERE email = ? AND password = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);
            stmt.setString(2, password); // In production, use hashed passwords

            ResultSet rs = stmt.executeQuery();
            return rs.next();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean signUp(String email, String username,String password) {
        String checkSql = "SELECT * FROM user WHERE email = ?";
        String insertSql = "INSERT INTO user (email, name,password, fkAccess) VALUES (?, ?, ?, 1)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement checkStmt = conn.prepareStatement(checkSql)) {

            checkStmt.setString(1, email);
            ResultSet rs = checkStmt.executeQuery();

            if (rs.next()) {
                // Email already exists
                return false;
            }

            try (PreparedStatement insertStmt = conn.prepareStatement(insertSql)) {
                insertStmt.setString(1, email);
                insertStmt.setString(2, username);
                insertStmt.setString(3, password); // Hash in production!
                insertStmt.executeUpdate();
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
