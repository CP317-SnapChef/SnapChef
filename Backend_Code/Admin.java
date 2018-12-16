package snapchefUsers;

import java.util.ArrayList;
import snapchef.Recipe;
import snapchef.AddRecipe;
import snapchef.Ingredient;
import snapchef.AddIngredient;

/**
 * Admin Class Definition
 *
 * @author Gong-Fan Bao
 * @version 2018-11-22
 */
public class Admin extends User{
 String userName = "";
 String password = "";
 ArrayList<Recipe> savedRecipes = new ArrayList<Recipe>();
 ArrayList<Recipe> tempRecipes = new ArrayList<Recipe>();
 Boolean isAdmin = true;
	 
	//Constructor
	public Admin(String userName, String password, ArrayList<Recipe> savedRecipes, Boolean isAdmin) {
		super(userName, password, savedRecipes, isAdmin);
	}
	
	public void addRecipe(String dbConnection, Recipe recipe) {
		AddRecipe.addRecipe(dbConnection, recipe); //TODO no idea if this works
	}
	
	public void addIngredient(String dbConnection, Ingredient ingredient) {
		AddIngredient.addIngredient(dbConnection, ingredient); //TODO no idea if this works
	}
}
