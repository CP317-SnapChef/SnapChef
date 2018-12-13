package app.snapchef.com.base;

public class Recipe {
    private String recipeName;
    private String author;
    private String description;
    private String ingredients;
    private String instructions;


    public Recipe(String recipeName, String author, String description, String ingredients, String instructions) {
        this.recipeName = recipeName;
        this.author = author;
        this.description = description;
        this.ingredients = ingredients;
        this.instructions = instructions;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getAuthor() {
        return this.author;
    }

    public String getDescription() {
        return this.description;
    }

    public String getIngredients() {
        return this.ingredients;
    }

    public String getInstructions() {
        return this.instructions;
    }

}