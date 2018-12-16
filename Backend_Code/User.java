package snapchefUsers;

import java.util.ArrayList;
import snapchef.Recipe;

/**
 * User Class Definition
 *
 * @author Gong-Fan Bao
 * @version 2018-11-22
 */
public class User extends Guest{
 String userName = "";
 String password = "";
 ArrayList<Recipe> savedRecipes = new ArrayList<Recipe>();
 ArrayList<Recipe> tempRecipes = new ArrayList<Recipe>();
 Boolean isAdmin = false;
 
	//Constructor
	public User(String userName, String password, ArrayList<Recipe> savedRecipes, Boolean isAdmin) {
		this.userName = userName;
		this.password = password;
		this.savedRecipes = savedRecipes;
		this.isAdmin = isAdmin;
	}
	
	public void saveRecipe(String dbConneciton, Recipe recipe) {
		//Send recipe to database -> Database adds it to the savedRecipes of the user
	}
	
	public ArrayList<Recipe> viewRecipe() {
		//TODO check with frontend on what this function is supposed to do
		
		return tempRecipes;
	}
	
	public ArrayList<Recipe> searchRecipe() {
		//TODO check with frontend on what this function is supposed to do
		
		return tempRecipes;
	}
	
	//Getters
	public String getUserName() {
		return this.userName;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public ArrayList<Recipe> getSavedRecipes() {
		return this.savedRecipes;
	}
	
	public Boolean getIsAdmin() {
		return this.isAdmin;
	}
	
	//Setters
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
}
