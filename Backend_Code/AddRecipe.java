//import recipe class
import snapchef.Ingredient;
import java.util.*;

package snapchef;

/**
 * AddRecipe Class Definition
 *
 * @author Gong-Fan Bao
 * @version 2018-11-14
 */
public class AddRecipe implements Recipe{
	
	//TO DO rewrite everything with Recipe Superclass, no need to rewrite methods again
	
	private String recipeName = "";
	private double rating = -1;
	private int prepTime = -1;
	private int cookTime = -1;
	private int servings = -1;
	private ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>(); // potential error?
	private ArrayList<String> instructions = new ArrayList<String>(); // potential error?
	private String description = "";
	private Boolean isPeanutFree = null;
	private Boolean isVegetarian = null;
	private Boolean isVegan = null;
	
	//Constructor
	public AddRecipe (String recipeName, double rating, int prepTime, int cookTime, int servings, 
			ArrayList<Ingredient> ingredients, ArrayList<String> instructions, String description, Boolean isPeanutFree, 
			Boolean isVegetarian, Boolean isVegan) {
		
		this.recipeName = recipeName;
		this.rating = rating;
		this.prepTime = prepTime;
		this.cookTime = cookTime;
		this.servings = servings;
		this.ingredients = ingredients;
		this.instructions = instructions;
		this.description = description;
		this.isPeanutFree = null;
		this.isVegetarian = null;
		this.isVegan = null;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
