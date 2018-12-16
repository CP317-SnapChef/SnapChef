//
//  SearchViewController.swift
//  SnapChef
//
//  Created by Dylan Clarry on 2018-11-19.
//  Copyright © 2018 SnapChefTeam. All rights reserved.
//

import UIKit


class SearchViewController: UIViewController, UITableViewDelegate, UITableViewDataSource, UITabBarDelegate {
    
    // MARK: variables
    //lazy var searchBar: UISearchBar = UISearchBar(frame: CGRect(origin: CGPoint(x: 0,y :0), size: CGSize(width: 300, height: 20)))
    var savedTab = false
    
    
    // MARK: outlets
    
    // MARK: functions
   
    override func viewDidLoad() {
        super.viewDidLoad()
        
        //let searchBar = UISearchController(searchResultsController: nil)
        //self.searchBar.delegate = self
        
         UITabBarItem.appearance().setTitleTextAttributes([NSAttributedString.Key.font: UIFont.systemFont(ofSize: 15)], for: .normal)
        
        //navigationItem.searchController = searchBar
        
//        searchBar.placeholder = "Your placeholder"
//        self.navigationItem.rightBarButtonItem = UIBarButtonItem(customView:searchBar)
    }
    
    public func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        // #warning Incomplete implementation, return the number of rows
            return recipes.count
    }
    
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        cellIndex = indexPath.row
        performSegue(withIdentifier: "segue_SearchRecipeView->RecipeView", sender: self)
    }
    
   public func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        
        // configure cell
        let cell = tableView.dequeueReusableCell(withIdentifier: "CellTemplate", for: indexPath) as! RecipeCell
    
        let recipe = recipes[indexPath.row]
            cell.setStars(recipe: recipe)

    tableView.rowHeight = 242
    

        return cell
    }

    
    // MARK: actions
  

}


