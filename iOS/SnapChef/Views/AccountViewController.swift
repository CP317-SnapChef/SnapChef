//
//  AccountViewController.swift
//  SnapChef
//
//  Created by Dylan Clarry on 2018-11-18.
//  Copyright © 2018 SnapChefTeam. All rights reserved.
//

import UIKit

class AccountViewController: UIViewController {
    
    // MARK: outlets
    @IBOutlet weak var accountView_Username: UILabel!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        setCustomBackBtn()
        accountView_Username.text = username
    }
    
    // customize navbar
    func setCustomBackBtn() {
        navigationItem.backBarButtonItem = UIBarButtonItem(title: "", style: .plain, target: nil, action: nil)
        navigationController?.navigationBar.backIndicatorImage = #imageLiteral(resourceName: "BackArrowExtraSmall")
        navigationController?.navigationBar.backIndicatorTransitionMaskImage = #imageLiteral(resourceName: "BackArrowExtraSmall")
    }
    
    // MARK: actions
    
    /* logout button */
    @IBAction func accountView_LogoutBtn(_ sender: UIButton) {
        recipes = [Recipe]()
        performSegue(withIdentifier: "segue_Account->Login", sender: self)
    }
    
    /* change password button */
    @IBAction func accountView_ChangePasswordBtn(_ sender: UIButton) {
        performSegue(withIdentifier: "segue_Account->ChangePassword", sender: self)
    }
    
    /* report error button */
    @IBAction func accountView_ReportErrorBtn(_ sender: UIButton) {
        performSegue(withIdentifier: "segue_Account->ReportError", sender: self)
    }
}
