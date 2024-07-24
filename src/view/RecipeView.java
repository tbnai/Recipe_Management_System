package view;

import controller.RecipeController;
import model.Recipe;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RecipeView {
    private RecipeController recipeController;
    private JFrame frame;
    private JTextField titleField;
    private JTextArea ingredientsArea;
    private JTextArea instructionsArea;
    private JTextField categoryField;
    private JTextField searchField;
    private JButton addButton;
    private JButton searchButton;
    private JTextArea resultArea;

    public RecipeView(RecipeController recipeController) {
        this.recipeController = recipeController;
        frame = new JFrame("Recipe Manager");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel titleLabel = new JLabel("Title:");
        titleLabel.setBounds(20, 20, 80, 25);
        frame.add(titleLabel);

        titleField = new JTextField(20);
        titleField.setBounds(100, 20, 160, 25);
        frame.add(titleField);

        JLabel ingredientsLabel = new JLabel("Ingredients:");
        ingredientsLabel.setBounds(20, 60, 80, 25);
        frame.add(ingredientsLabel);

        ingredientsArea = new JTextArea();
        ingredientsArea.setBounds(100, 60, 160, 75);
        frame.add(ingredientsArea);

        JLabel instructionsLabel = new JLabel("Instructions:");
        instructionsLabel.setBounds(20, 150, 80, 25);
        frame.add(instructionsLabel);

        instructionsArea = new JTextArea();
        instructionsArea.setBounds(100, 150, 160, 75);
        frame.add(instructionsArea);

        JLabel categoryLabel = new JLabel("Category:");
        categoryLabel.setBounds(20, 240, 80, 25);
        frame.add(categoryLabel);

        categoryField = new JTextField(20);
        categoryField.setBounds(100, 240, 160, 25);
        frame.add(categoryField);

        addButton = new JButton("Add Recipe");
        addButton.setBounds(20, 280, 240, 25);
        frame.add(addButton);

        JLabel searchLabel = new JLabel("Search:");
        searchLabel.setBounds(300, 20, 80, 25);
        frame.add(searchLabel);

        searchField = new JTextField(20);
        searchField.setBounds(380, 20, 160, 25);
        frame.add(searchField);

        searchButton = new JButton("Search");
        searchButton.setBounds(300, 60, 240, 25);
        frame.add(searchButton);

        resultArea = new JTextArea();
        resultArea.setBounds(300, 100, 240, 175);
        frame.add(resultArea);

        frame.setVisible(true);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = titleField.getText();
                String ingredients = ingredientsArea.getText();
                String instructions = instructionsArea.getText();
                String category = categoryField.getText();

                Recipe recipe = new Recipe(title, ingredients, instructions, category);
                recipeController.addRecipe(recipe, 1); // Assume userId is 1 for simplicity
                JOptionPane.showMessageDialog(frame, "Recipe added successfully!");
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String keyword = searchField.getText();
                java.util.List<Recipe> recipes = recipeController.searchRecipes(keyword);

                StringBuilder results = new StringBuilder();
                for (Recipe recipe : recipes) {
                    results.append("Title: ").append(recipe.getTitle()).append("\n");
                    results.append("Ingredients: ").append(recipe.getIngredients()).append("\n");
                    results.append("Instructions: ").append(recipe.getInstructions()).append("\n");
                    results.append("Category: ").append(recipe.getCategory()).append("\n\n");
                }
                resultArea.setText(results.toString());
            }
        });
    }
}
