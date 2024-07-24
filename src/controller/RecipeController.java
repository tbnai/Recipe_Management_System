package controller;

import model.Recipe;
import utils.DatabaseUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RecipeController {
    public void addRecipe(Recipe recipe, int userId) {
        String query = "INSERT INTO recipes (title, ingredients, instructions, category, user_id) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseUtils.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, recipe.getTitle());
            stmt.setString(2, recipe.getIngredients());
            stmt.setString(3, recipe.getInstructions());
            stmt.setString(4, recipe.getCategory());
            stmt.setInt(5, userId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateRecipe(int id, Recipe recipe) {
        String query = "UPDATE recipes SET title = ?, ingredients = ?, instructions = ?, category = ? WHERE id = ?";

        try (Connection connection = DatabaseUtils.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, recipe.getTitle());
            stmt.setString(2, recipe.getIngredients());
            stmt.setString(3, recipe.getInstructions());
            stmt.setString(4, recipe.getCategory());
            stmt.setInt(5, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteRecipe(int id) {
        String query = "DELETE FROM recipes WHERE id = ?";

        try (Connection connection = DatabaseUtils.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Recipe> searchRecipes(String keyword) {
        List<Recipe> result = new ArrayList<>();
        String query = "SELECT * FROM recipes WHERE title LIKE ? OR ingredients LIKE ? OR category LIKE ?";

        try (Connection connection = DatabaseUtils.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            String searchPattern = "%" + keyword + "%";
            stmt.setString(1, searchPattern);
            stmt.setString(2, searchPattern);
            stmt.setString(3, searchPattern);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Recipe recipe = new Recipe(
                        rs.getString("title"),
                        rs.getString("ingredients"),
                        rs.getString("instructions"),
                        rs.getString("category")
                );
                result.add(recipe);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
