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
public class Search {
    ArrayList searchItems = new ArrayList<String>();
    private Boolean ifIngredient; 

    public Search(ArrayList<String> searchItems, Boolean ifIngredients) {
        this.ifIngredient = ifIngredient;
        this.searchItems = searchItems;
        
    }
    
    public ArrayList<Recipe> searchRecipe(){
        ArrayList recipeList = new ArrayList<Recipe>();
      if(this.ifIngredient == true){
            /* Add the lambda function to search the databsse by the ingredient names
            ,create recipe objects and add them to the arraylist 
          */
      }  
      else{
          // Add the lambda function to search the databse by the name of recipe
      }
      return recipeList;
    }
    
    
    
    
}
