package snapchef;

/**
 * Ingredient Class Definition
 *
 * @author Gong-Fan Bao
 * @version 2018-11-14
 */
public class Ingredient {
	private String ingredientName = "";
	private int amount = -1;
	private String unit = "";
	
	//Constructor
	public Ingredient (String ingredientName, int amount, String unit) {
		this.ingredientName = ingredientName;
		this.amount = amount;
		this.unit = unit;
	}
	
	//Main
	public static void main(final String[] args) {
		//Testing
		String iName = "peanut";
		int iAmount = 25;
		String iUnit = "grams";
		
		Ingredient peanut = new Ingredient(iName, iAmount, iUnit);
		
	}
	
	//Getters
	public String getIngredientName() {
		return this.ingredientName;
	}
	
	public int getAmount() {
		return this.amount;
	}
	
	public String getUnit() {
		return this.unit;
	}
	
	//Setters
	public void setIngredientName(String ingredientName) {
		this.ingredientName = ingredientName;
		return;
	}
	
	public void setAmount(int amount) {
		this.amount = amount;
		return;
	}
	
	public void setUnit(String unit) {
		this.unit = unit;
		return;
	}
}
