
//
//  ReportRecipeViewController.swift
//  SnapChef
//
//  Created by Dylan Clarry on 2018-11-19.
//  Copyright © 2018 SnapChefTeam. All rights reserved.
//

import UIKit

class ReportRecipeViewController: UIViewController, UITextViewDelegate {
    
    var recipe = recipes[cellIndex]
        
    // MARK: outlets
    @IBOutlet weak var reportRecipeView_RecipeImage: UIImageView!
    @IBOutlet weak var reportRecipeView_RecipeName: UILabel!
    @IBOutlet weak var reportRecipeView_RecipeAuthor: UILabel!
    
    @IBOutlet weak var reportRecipeView_Star1: UIImageView!
    @IBOutlet weak var reportRecipeView_Star2: UIImageView!
    @IBOutlet weak var reportRecipeView_Star3: UIImageView!
    @IBOutlet weak var reportRecipeView_Star4: UIImageView!
    @IBOutlet weak var reportRecipeView_Star5: UIImageView!
    @IBOutlet weak var reportRecipeView_TextField: UITextView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        reportRecipeView_TextField.delegate = self
        
        reportRecipeView_TextField.layer.borderWidth = 1
        reportRecipeView_TextField.layer.borderColor = UIColor.colorMuskyGrey.cgColor
        reportRecipeView_TextField.layer.cornerRadius = 6
        loadRecipe()
        
        // keyboard listen events
        NotificationCenter.default.addObserver(self, selector: #selector(keyboardWillChange(notification:)), name: UIResponder.keyboardWillShowNotification, object: nil)
        NotificationCenter.default.addObserver(self, selector: #selector(keyboardWillChange(notification:)), name: UIResponder.keyboardWillHideNotification, object: nil)
        NotificationCenter.default.addObserver(self, selector: #selector(keyboardWillChange(notification:)), name: UIResponder.keyboardWillChangeFrameNotification, object: nil)
        
//        let tap: UITapGestureRecognizer = UITapGestureRecognizer(target: self, action: "dismissKeyboard")
//        view.addGestureRecognizer(tap)
    }
    
    deinit {
        
        // stop keyboard listen events
        NotificationCenter.default.removeObserver(self, name: UIResponder.keyboardWillShowNotification, object: nil)
        NotificationCenter.default.removeObserver(self, name: UIResponder.keyboardWillHideNotification, object: nil)
        NotificationCenter.default.removeObserver(self, name: UIResponder.keyboardWillChangeFrameNotification, object: nil)
    }
    
    // MARK: functions
    
    func loadRecipe() {
        reportRecipeView_RecipeImage.image = UIImage(named: recipe.image)
        reportRecipeView_RecipeImage.layer.borderWidth = 1
        reportRecipeView_RecipeImage.layer.borderColor = UIColor.colorMuskyGrey.cgColor
        reportRecipeView_RecipeImage.layer.cornerRadius = 6
        reportRecipeView_RecipeName.text = recipe.name
        reportRecipeView_RecipeAuthor.text = "By: " + recipe.author
        
        if recipe.rating < 5.0{
            reportRecipeView_Star5.image = #imageLiteral(resourceName: "HalfYellowStar-1")
        }
        if recipe.rating < 4.3{
            reportRecipeView_Star5.image = #imageLiteral(resourceName: "NoYellowStar.png")
        }
        if recipe.rating < 4.0{
            reportRecipeView_Star4.image = #imageLiteral(resourceName: "HalfYellowStar-1")
        }
        if recipe.rating < 3.3{
            reportRecipeView_Star4.image = #imageLiteral(resourceName: "NoYellowStar.png")
        }
        if recipe.rating < 3.0{
            reportRecipeView_Star3.image = #imageLiteral(resourceName: "HalfYellowStar-1")
        }
        if recipe.rating < 2.3{
            reportRecipeView_Star3.image = #imageLiteral(resourceName: "NoYellowStar.png")
        }
        if recipe.rating < 2.0{
            reportRecipeView_Star2.image = #imageLiteral(resourceName: "HalfYellowStar-1")
        }
        if recipe.rating < 1.3{
            reportRecipeView_Star2.image = #imageLiteral(resourceName: "NoYellowStar.png")
        }
        if recipe.rating < 1.0{
            reportRecipeView_Star1.image = #imageLiteral(resourceName: "HalfYellowStar-1")
        }
        if recipe.rating < 0.3{
            reportRecipeView_Star1.image = #imageLiteral(resourceName: "NoYellowStar.png")
        }
    }
    
//    func dismissKeyboard() {
//        Keyboard.hideKeyboard(inputField: reportRecipeView_TextField)
//    }
    
    // UITextFieldDelegate functions
    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
        Keyboard.hideKeyboard(inputField: textField)
        return true
    }
    
    /* keyboard height adjustments */
    @objc func keyboardWillChange(notification: Notification) {
        let key = "UIKeyboardFrameEndUserInfoKey"
        guard let keyboardRect = (notification.userInfo?[key] as? NSValue)?.cgRectValue else { return }
        
        // adjust to height of keyboard
        if notification.name == UIResponder.keyboardWillShowNotification || notification.name == UIResponder.keyboardWillChangeFrameNotification {
            view.frame.origin.y = -keyboardRect.height / 3
        } else {
            // reset height from keyboard
            view.frame.origin.y = 0
        }
    }
    
    // MARK: actions
    
    /* report recipe button */
    @IBAction func reportRecipeView_ReportBtn(_ sender: Any) {
        
    }
}
