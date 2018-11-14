/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snapchef_backend;

import java.util.ArrayList;

/**
 *
 * @author Jot
 */
public class Recipe {
 private String recipeName;
 private double rating;
 private int prepTime;
 private int cookTime;
 private int servings;
 ArrayList ingredients = new ArrayList<Ingredients>();
 ArrayList instructions = new ArrayList<String>();
 private String description;
 private Boolean isPeanutFree;
 private Boolean isVegetarian;
 private Boolean isVegan;

    public Recipe(String recipeName, double rating, int prepTime, int cookTime, int servings, String description, Boolean isPeanutFree, Boolean isVegetarian, Boolean isVegan) {
        this.recipeName = recipeName;
        this.rating = rating;
        this.prepTime = prepTime;
        this.cookTime = cookTime;
        this.servings = servings;
        this.description = description;
        this.isPeanutFree = isPeanutFree;
        this.isVegetarian = isVegetarian;
        this.isVegan = isVegan;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setPrepTime(int prepTime) {
        this.prepTime = prepTime;
    }

    public void setCookTime(int cookTime) {
        this.cookTime = cookTime;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public void setIngredients(ArrayList ingredients) {
        this.ingredients = ingredients;
    }

    public void setInstructions(ArrayList instructions) {
        this.instructions = instructions;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIsPeanutFree(Boolean isPeanutFree) {
        this.isPeanutFree = isPeanutFree;
    }

    public void setIsVegetarian(Boolean isVegetarian) {
        this.isVegetarian = isVegetarian;
    }

    public void setIsVegan(Boolean isVegan) {
        this.isVegan = isVegan;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public double getRating() {
        return rating;
    }

    public int getPrepTime() {
        return prepTime;
    }

    public int getCookTime() {
        return cookTime;
    }

    public int getServings() {
        return servings;
    }

    public ArrayList getIngredients() {
        return ingredients;
    }

    public ArrayList getInstructions() {
        return instructions;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getIsPeanutFree() {
        return isPeanutFree;
    }

    public Boolean getIsVegetarian() {
        return isVegetarian;
    }

    public Boolean getIsVegan() {
        return isVegan;
    }
 
 
}
