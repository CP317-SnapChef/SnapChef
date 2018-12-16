//
//  HomepageViewController.swift
//  SnapChef
//
//  Created by Dylan Clarry on 2018-11-18.
//  Copyright © 2018 SnapChefTeam. All rights reserved.
//

import UIKit

var cellIndex = 0

class HomepageViewController: UITableViewController {
    
    // MARK: outlets
    
    override func viewDidLoad() {
        super.viewDidLoad()
        setCustomBackBtn()
    }
    
    // MARK: functions
    
    // customize navbar
    func setCustomBackBtn() {
        navigationItem.backBarButtonItem = UIBarButtonItem(title: "", style: .plain, target: nil, action: nil)
        navigationController?.navigationBar.backIndicatorImage = #imageLiteral(resourceName: "BackArrowExtraSmall")
        navigationController?.navigationBar.backIndicatorTransitionMaskImage = #imageLiteral(resourceName: "BackArrowExtraSmall")
    }
    
    override func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        cellIndex = indexPath.row
        performSegue(withIdentifier: "segue_Homepage->ViewRecipe", sender: self)
        
    }
    
    override func numberOfSections(in tableView: UITableView) -> Int {
        // #warning Incomplete implementation, return the number of sections
        return 1
    }
    
    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        // #warning Incomplete implementation, return the number of rows
        return recipes.count
    }
    
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        
        // configure cell
        let cell = tableView.dequeueReusableCell(withIdentifier: "CellTemplate", for: indexPath) as! RecipeCell
        let recipe = recipes[indexPath.row]
        cell.setStars(recipe: recipe)
        
        tableView.rowHeight = 242
        
        return cell
    }
    
    // MARK: actions
    
    /* account button */
    @IBAction func homepageView_AccountBtn(_ sender: UIButton) {
        performSegue(withIdentifier: "segue_Homepage->Account", sender: self)
    }
    
    /* search button */
    @IBAction func homepageView_SearchBtn(_ sender: UIButton) {
        performSegue(withIdentifier: "segue_Homepage->Search", sender: self)
    }
}
