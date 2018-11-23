package snapchefUsers;

import snapchef.Recipe;
import snapchef.Ingredient;
import java.util.ArrayList;

/**
 * Guest Class Definition
 *
 * @author Gong-Fan Bao
 * @version 2018-11-21
 */
public class Guest {
	
	ArrayList ing = new ArrayList<Ingredient>();
	ArrayList recipes = new ArrayList<Recipe>();
	
	public ArrayList<Recipe> searchByText(ArrayList<Ingredient> ing) {
		
		// TODO get recipes from database
		
		return recipes;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
