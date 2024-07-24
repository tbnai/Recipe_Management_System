package controller;

import model.User;
import utils.DatabaseUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserController {
    public boolean register(String username, String password) {
        String query = "INSERT INTO users (username, password) VALUES (?, ?)";

        try (Connection connection = DatabaseUtils.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, username);
            stmt.setString(2, password); // Store password as plaintext
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean login(String username, String password) {
        String query = "SELECT password FROM users WHERE username = ?";

        try (Connection connection = DatabaseUtils.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String storedPassword = rs.getString("password");
                return storedPassword.equals(password); // Check plaintext password
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public User getUserByUsername(String username) {
        String query = "SELECT * FROM users WHERE username = ?";

        try (Connection connection = DatabaseUtils.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new User(rs.getString("username"), rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
