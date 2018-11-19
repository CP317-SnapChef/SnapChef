//
//  HomepageViewController.swift
//  SnapChef
//
//  Created by Dylan Clarry on 2018-11-18.
//  Copyright © 2018 SnapChefTeam. All rights reserved.
//

import UIKit

var index = 0
var recipes = [Recipe]()

class HomepageViewController: UITableViewController {
    override func viewDidLoad() {
        super.viewDidLoad()
        
    }
    
    // MARK: functions
    
    override func numberOfSections(in tableView: UITableView) -> Int {
        // #warning Incomplete implementation, return the number of sections
        return 1
    }
    
    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        // #warning Incomplete implementation, return the number of rows
        return recipes.count
    }
    
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "CellTemplate", for: indexPath) as! RecipeCell
        
        // configure cell
        let recipe = recipes[indexPath.row]
        
        // calculate and show stars
        if recipe.rating < 5.0{
            cell.recipeCell_Star5.image = #imageLiteral(resourceName: "HalfYellowStar-1")
        }
        if recipe.rating < 4.3{
            cell.recipeCell_Star5.image = #imageLiteral(resourceName: "NoYellowStar.png")
        }
        if recipe.rating < 4.0{
            cell.recipeCell_Star4.image = #imageLiteral(resourceName: "HalfYellowStar-1")
        }
        if recipe.rating < 3.3{
            cell.recipeCell_Star4.image = #imageLiteral(resourceName: "NoYellowStar.png")
        }
        if recipe.rating < 3.0{
            cell.recipeCell_Star3.image = #imageLiteral(resourceName: "HalfYellowStar-1")
        }
        if recipe.rating < 2.3{
            cell.recipeCell_Star3.image = #imageLiteral(resourceName: "NoYellowStar.png")
        }
        if recipe.rating < 2.0{
            cell.recipeCell_Star2.image = #imageLiteral(resourceName: "HalfYellowStar-1")
        }
        if recipe.rating < 1.3{
            cell.recipeCell_Star2.image = #imageLiteral(resourceName: "NoYellowStar.png")
        }
        if recipe.rating < 1.0{
            cell.recipeCell_Star1.image = #imageLiteral(resourceName: "HalfYellowStar")
        }
        if recipe.rating < 0.3{
            cell.recipeCell_Star1.image = #imageLiteral(resourceName: "NoYellowStar.png")
        }
        
        // fill cell
        cell.recipeCell_ImageView.image = UIImage(named: recipe.image)
        cell.recipeCell_RecipeName.text = recipe.name
        cell.recipeCell_RecipeAuthor.text = "By: " + recipe.author
        
        tableView.rowHeight = 242
        
        return cell
    }
}
