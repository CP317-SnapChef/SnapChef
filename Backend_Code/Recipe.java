/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snapchef;

import java.util.ArrayList;

/**
 *Recipe Class
 *
 * @author Jot, Gong-Fan Bao
 * @version 2018-11-21
 */
public class Recipe {
 private String recipeName = "";
 private double rating = -1;
 private int prepTime = 0;
 private int cookTime = 0;
 private int servings = 0;
 ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
 ArrayList<String> instructions = new ArrayList<String>();
 private String description = "";
 private Boolean isPeanutFree;
 private Boolean isVegetarian;
 private Boolean isVegan;
 
 	//Constructor
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

    //Setters
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

    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public void setInstructions(ArrayList<String> instructions) {
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

    //Getters
    public String getRecipeName() {
        return this.recipeName;
    }

    public double getRating() {
        return this.rating;
    }

    public int getPrepTime() {
        return this.prepTime;
    }

    public int getCookTime() {
        return this.cookTime;
    }

    public int getServings() {
        return this.servings;
    }

    public ArrayList<Ingredient> getIngredients() {
        return this.ingredients;
    }

    public ArrayList<String> getInstructions() {
        return this.instructions;
    }

    public String getDescription() {
        return this.description;
    }

    public Boolean getIsPeanutFree() {
        return this.isPeanutFree;
    }

    public Boolean getIsVegetarian() {
        return this.isVegetarian;
    }

    public Boolean getIsVegan() {
        return this.isVegan;
    }
 
 
}
