package model;

public class Recipe {
    private String title;
    private String ingredients;
    private String instructions;
    private String category;
    private int servingSize;
    private int cookingTime;
    private String image;

    // Constructors, getters, and setters
    public Recipe(String title, String ingredients, String instructions, String category) {
        this.title = title;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.category = category;
    }

    // Getters and setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getServingSize() {
        return servingSize;
    }

    public void setServingSize(int servingSize) {
        this.servingSize = servingSize;
    }

    public int getCookingTime() {
        return cookingTime;
    }

    public void setCookingTime(int cookingTime) {
        this.cookingTime = cookingTime;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
