package snapchef; 

import snapchef.Recipe;

/**
 * AddRecipe Class Definition
 *
 * @author Gong-Fan Bao
 * @version 2018-11-21
 */
public class AddRecipe extends Recipe{

	//Constructor
	public AddRecipe(String recipeName, double rating, int prepTime, int cookTime, int servings, String description, Boolean isPeanutFree, Boolean isVegetarian, Boolean isVegan) {
		super(recipeName, rating, prepTime, cookTime, servings, description, isPeanutFree, isVegetarian, isVegan);
		
	}

	public static void addRecipe(String dbConnection, Recipe recipe) {
		//TODO add recipe to database connection
	}

}
