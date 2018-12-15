package app.snapchef.com.base;

public class Recipe {
    private String recipeName;
    private String rating;
    private String ingredients;
    private String instructions;


    public Recipe(String recipeName, String rating, String ingredients, String instructions) {
        this.recipeName = recipeName;
        this.rating = rating;
        this.ingredients = ingredients;
        this.instructions = instructions;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getRecipeName() {
        return this.recipeName;
    }

    public String getRating() {
        return this.rating;
    }

    public String getIngredients() {
        return this.ingredients;
    }

    public String getInstructions() {
        return this.instructions;
    }

}