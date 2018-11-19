//
//  ViewRecipeController.swift
//  SnapChef
//
//  Created by Dylan Clarry on 2018-11-18.
//  Copyright © 2018 SnapChefTeam. All rights reserved.
//

import UIKit

class ViewRecipeViewController: UIViewController{
    
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
    }
    
    // MARK: actions
    @IBAction func viewRecipeView_SaveThisRecipeBtn(_ sender: UIButton) {
    }
    
    @IBAction func viewRecipeView_ReportRecipeBtn(_ sender: UIButton) {
    }
}
