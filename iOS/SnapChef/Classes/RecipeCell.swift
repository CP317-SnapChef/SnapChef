//
//  RecipeCell.swift
//  SnapChef
//
//  Created by Dylan Clarry on 2018-11-18.
//  Copyright © 2018 SnapChefTeam. All rights reserved.
//

import UIKit

class RecipeCell: UITableViewCell {

    // stars
    @IBOutlet weak var recipeCell_Panel: UIView!
    @IBOutlet weak var recipeCell_Star1: UIImageView!
    @IBOutlet weak var recipeCell_Star2: UIImageView!
    @IBOutlet weak var recipeCell_Star3: UIImageView!
    @IBOutlet weak var recipeCell_Star4: UIImageView!
    @IBOutlet weak var recipeCell_Star5: UIImageView!
    
    // image and labels
    @IBOutlet weak var recipeCell_ImageView: UIImageView!
    @IBOutlet weak var recipeCell_RecipeName: UILabel!
    @IBOutlet weak var recipeCell_RecipeAuthor: UILabel!
    
    
    // MARK: functions
    func setStars(recipe: Recipe) {
        if recipe.rating < 5.0{
            self.recipeCell_Star5.image = #imageLiteral(resourceName: "HalfYellowStar-1")
        }
        if recipe.rating < 4.3{
            self.recipeCell_Star5.image = #imageLiteral(resourceName: "NoYellowStar.png")
        }
        if recipe.rating < 4.0{
            self.recipeCell_Star4.image = #imageLiteral(resourceName: "HalfYellowStar-1")
        }
        if recipe.rating < 3.3{
            self.recipeCell_Star4.image = #imageLiteral(resourceName: "NoYellowStar.png")
        }
        if recipe.rating < 3.0{
            self.recipeCell_Star3.image = #imageLiteral(resourceName: "HalfYellowStar-1")
        }
        if recipe.rating < 2.3{
            self.recipeCell_Star3.image = #imageLiteral(resourceName: "NoYellowStar.png")
        }
        if recipe.rating < 2.0{
            self.recipeCell_Star2.image = #imageLiteral(resourceName: "HalfYellowStar-1")
        }
        if recipe.rating < 1.3{
            self.recipeCell_Star2.image = #imageLiteral(resourceName: "NoYellowStar.png")
        }
        if recipe.rating < 1.0{
            self.recipeCell_Star1.image = #imageLiteral(resourceName: "HalfYellowStar-1")
        }
        if recipe.rating < 0.3{
            self.recipeCell_Star1.image = #imageLiteral(resourceName: "NoYellowStar.png")
        }
        
        // fill cell
        self.recipeCell_ImageView.image = UIImage(named: recipe.image)
        self.recipeCell_RecipeName.text = recipe.name
        self.recipeCell_RecipeAuthor.text = "By: " + recipe.author
        self.recipeCell_Panel.layer.borderWidth = 1
        self.recipeCell_Panel.layer.borderColor = UIColor.colorMuskyGrey.cgColor
        self.recipeCell_Panel.layer.cornerRadius = 6
    }
    
    override func awakeFromNib() {
        super.awakeFromNib()
        // Initialization code
    }

    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)

        // Configure the view for the selected state
    }

}
