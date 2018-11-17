//
//  LoginViewController.swift
//  SnapChef
//
//  Created by Dylan Clarry and Bryan Mietkiewicz on 2018-11-17.
//  Copyright © 2018 SnapChefTeam. All rights reserved.
//

import UIKit

class LoginViewController: UIViewController, UITextFieldDelegate {
    
    // MARK: outlets
    @IBOutlet weak var loginView_UsernameInputField: UITextField!
    @IBOutlet weak var loginView_PasswordInputField: UITextField!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        loginView_UsernameInputField.delegate = self
        loginView_PasswordInputField.delegate = self
    }
    
    // MARK: actions
    @IBAction func loginView_LoginBtn(_ sender: UIButton) {
        
    }
    @IBAction func loginView_SignupBtn(_ sender: UIButton) {
      
    }
    
    // MARK: helper functions
    func hideKeyboard(inputField: UITextField) {
        inputField.resignFirstResponder()
    }
    
    // MARK: UITextFieldDelegate functions
    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
        hideKeyboard(inputField: textField)
        return true
    }
}
