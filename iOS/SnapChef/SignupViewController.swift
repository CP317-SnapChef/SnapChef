//
//  SignupViewController.swift
//  SnapChef
//
//  Created by Dylan Clarry on 2018-11-17.
//  Copyright © 2018 SnapChefTeam. All rights reserved.
//

import UIKit

class SignupViewController: UIViewController, UITextFieldDelegate {
    
    // MARK: outlets
    @IBOutlet weak var signupView_UsernameInputField: UITextField!
    @IBOutlet weak var signupView_PasswordInputField: UITextField!
    @IBOutlet weak var signupView_ConfirmPasswordInputField: UITextField!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
    }
}
