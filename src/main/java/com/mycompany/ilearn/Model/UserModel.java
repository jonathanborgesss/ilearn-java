package com.mycompany.ilearn.Model;

import com.mycompany.ilearn.Util.DBConnection;
import java.sql.*;

public class UserModel {
    public boolean authenticate(String username, String password) {
        String sql = "SELECT * FROM user WHERE name = ? AND password = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            stmt.setString(2, password); // In production, use hashed passwords

            ResultSet rs = stmt.executeQuery();
            return rs.next();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
