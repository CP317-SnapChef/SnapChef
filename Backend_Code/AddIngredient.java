package snapchef;

import snapchef.Ingredient;

/**
 * AddIngredient Class Definition
 *
 * @author Gong-Fan Bao
 * @version 2018-11-21
 */
public class AddIngredient extends Ingredient{
	
	//Constructor
	public AddIngredient (String ingredientName, int amount, String unit) {
		super(ingredientName, amount, unit);
	}
		
	public static void addIngredient(String dbConnection, Ingredient ingredient) {
		//TODO add recipe to database connection
	}
	
}
