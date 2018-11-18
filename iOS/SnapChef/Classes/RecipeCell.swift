//
//  RecipeCell.swift
//  SnapChef
//
//  Created by Dylan Clarry on 2018-11-18.
//  Copyright © 2018 SnapChefTeam. All rights reserved.
//

import UIKit

class RecipeCell: UITableViewCell {

    
    @IBOutlet weak var recipeCell_ImageView: UIImageView!
    @IBOutlet weak var recipeCell_RecipeName: UILabel!
    @IBOutlet weak var recipeCell_RecipeAuthor: UILabel!
    
    override func awakeFromNib() {
        super.awakeFromNib()
        // Initialization code
    }

    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)

        // Configure the view for the selected state
    }

}
