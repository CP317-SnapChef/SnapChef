//
//  ViewRecipeController.swift
//  SnapChef
//
//  Created by Dylan Clarry and Bryn Mietkiewicz on 2018-11-18.
//  Copyright © 2018 SnapChefTeam. All rights reserved.
//

import UIKit

class ViewRecipeViewController: UIViewController{
    
    var recipe = recipes[cellIndex]
    
    // MARK: outlets
    @IBOutlet weak var viewRecipeView_RecipeImage: UIImageView!
    @IBOutlet weak var viewRecipeView_RecipeName: UILabel!
    @IBOutlet weak var viewRecipeView_RecipeAuthor: UILabel!
    @IBOutlet weak var viewRecipeView_RecipeDescription: UITextView!
    
    @IBOutlet weak var viewRecipeView_RecipePrepTime: UILabel!
    @IBOutlet weak var viewRecipeView_RecipeCookTime: UILabel!
    @IBOutlet weak var viewRecipeView_RecipeServings: UILabel!
    
    @IBOutlet weak var viewRecipeView_Star1: UIImageView!
    @IBOutlet weak var viewRecipeView_Star2: UIImageView!
    @IBOutlet weak var viewRecipeView_Star3: UIImageView!
    @IBOutlet weak var viewRecipeView_Star4: UIImageView!
    @IBOutlet weak var viewRecipeView_Star5: UIImageView!
    
    @IBOutlet weak var viewRecipeView_RecipeIngredients: UITextView!
    @IBOutlet weak var viewRecipeView_RecipeInstructions: UITextView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        // remove label on back button
        setCustomBackBtn()
        
        // load recipe
        loadRecipe()
    }
    
    func setCustomBackBtn() {
        navigationItem.backBarButtonItem = UIBarButtonItem(title: "", style: .plain, target: nil, action: nil)
        navigationController?.navigationBar.backIndicatorImage = #imageLiteral(resourceName: "BackArrowExtraSmall")
        navigationController?.navigationBar.backIndicatorTransitionMaskImage = #imageLiteral(resourceName: "BackArrowExtraSmall")
    }
    
    func loadRecipe(){
        viewRecipeView_RecipeImage.image = UIImage(named: recipe.image)
        viewRecipeView_RecipeAuthor.text = recipe.author
        viewRecipeView_RecipeName.text = recipe.name
        recipeRating()
        recipePrepAndCookTimes()
        viewRecipeView_RecipeDescription.text = recipe.description
        servesThisMany()
        listIngredients()
        listInstructions()
    }
    
    func listIngredients(){
        viewRecipeView_RecipeIngredients.text = "\n   Ingredients:\n"
        for ingredient in recipe.ingredients{
            viewRecipeView_RecipeIngredients.text += "\n   \(ingredient)\n"
        }
        highlightFirstLineInTextView(textView: viewRecipeView_RecipeIngredients)
    }
    func listInstructions(){
        var count = 1
        viewRecipeView_RecipeInstructions.text  = "\n   Instructions:\n"
        for instruction in recipe.instructions{
            viewRecipeView_RecipeInstructions.text += "\n   \(count). \(instruction)\n"
            count += 1
        }
        highlightFirstLineInTextView(textView: viewRecipeView_RecipeInstructions)
    }
    
    func servesThisMany(){
        if recipe.serves > 1 {
            viewRecipeView_RecipeServings.text = String(recipe.serves) + " people"
        } else {
            viewRecipeView_RecipeServings.text = "1 person"
        }
    }
    
    func recipeRating(){
        if recipe.rating < 5.0{
            viewRecipeView_Star5.image = #imageLiteral(resourceName: "HalfYellowStar-1")
        }
        if recipe.rating < 4.3{
            viewRecipeView_Star5.image = #imageLiteral(resourceName: "NoYellowStar.png")
        }
        if recipe.rating < 4.0{
            viewRecipeView_Star4.image = #imageLiteral(resourceName: "HalfYellowStar-1")
        }
        if recipe.rating < 3.3{
            viewRecipeView_Star4.image = #imageLiteral(resourceName: "NoYellowStar.png")
        }
        if recipe.rating < 3.0{
            viewRecipeView_Star3.image = #imageLiteral(resourceName: "HalfYellowStar-1")
        }
        if recipe.rating < 2.3{
            viewRecipeView_Star3.image = #imageLiteral(resourceName: "NoYellowStar.png")
        }
        if recipe.rating < 2.0{
            viewRecipeView_Star2.image = #imageLiteral(resourceName: "HalfYellowStar-1")
        }
        if recipe.rating < 1.3{
            viewRecipeView_Star2.image = #imageLiteral(resourceName: "NoYellowStar.png")
        }
        if recipe.rating < 1.0{
            viewRecipeView_Star1.image = #imageLiteral(resourceName: "HalfYellowStar-1")
        }
        if recipe.rating < 0.3{
            viewRecipeView_Star1.image = #imageLiteral(resourceName: "NoYellowStar.png")
        }
    }
    func recipePrepAndCookTimes(){
        if recipe.prepTime > 60 && recipe.prepTime % 60 != 0{
            viewRecipeView_RecipePrepTime.text = String(recipe.prepTime / 60) + " hours " + String(recipe.prepTime % 60) + " minutes"
        }else if recipe.prepTime >= 60 && recipe.prepTime % 60 == 0{
            if recipe.prepTime == 60{
                viewRecipeView_RecipePrepTime.text = String(recipe.prepTime / 60) + " hour"
            }else{
                viewRecipeView_RecipePrepTime.text = String(recipe.prepTime / 60) + " hours "
            }
        }
        else{
            viewRecipeView_RecipePrepTime.text = String(recipe.prepTime) + " minutes"
            
        }
        if recipe.cookTime > 60 && recipe.cookTime % 60 != 0 {
            viewRecipeView_RecipeCookTime.text = String(recipe.cookTime / 60) + " hours " + String(recipe.cookTime % 60) + " minutes"
        }
        else if recipe.cookTime >= 60 && recipe.cookTime % 60 == 0{
            if recipe.cookTime == 60{
                viewRecipeView_RecipeCookTime.text = String(recipe.cookTime / 60) + " hour"
            }else{
                viewRecipeView_RecipeCookTime.text = String(recipe.cookTime / 60) + " hours "
            }
        }
        else{
            viewRecipeView_RecipeCookTime.text = String(recipe.cookTime) + " minutes"
        }
    }
    private func highlightFirstLineInTextView(textView: UITextView) {
        let textAsNSString = textView.text as NSString
        let lineBreakRange = textAsNSString.range(of: ":\n")
        let newAttributedText = NSMutableAttributedString(attributedString: textView.attributedText)
        let boldRange: NSRange
        if lineBreakRange.location < textAsNSString.length {
            boldRange = NSRange(location: 1, length: lineBreakRange.location)
        } else {
            boldRange = NSRange(location: 1, length: textAsNSString.length)
        }
        
        newAttributedText.addAttribute(NSAttributedString.Key.font, value: UIFont.preferredFont(forTextStyle: UIFont.TextStyle.headline), range: boldRange)
        textView.attributedText = newAttributedText
    }
    
    // MARK: actions
    
    /* save recipe button */
    @IBAction func viewRecipeView_SaveThisRecipeBtn(_ sender: UIButton) {
    }
    
    /* report recipe button */
    @IBAction func viewRecipeView_ReportRecipeBtn(_ sender: UIButton) {
        performSegue(withIdentifier: "segue_ViewRecipe->ReportRecipe", sender: self)
    }
}
