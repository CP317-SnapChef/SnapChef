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
        signupView_UsernameInputField.delegate = self
        signupView_PasswordInputField.delegate = self
        signupView_ConfirmPasswordInputField.delegate = self
    }
    
    // MARK: actions
    
    /* signup button */
    @IBAction func signupView_SignupBtn(_ sender: UIButton) {
        performSegue(withIdentifier: "segue_Signup->Login", sender: self)
    }
    
    /* UITextFieldDelegate functions */
    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
        Keyboard.hideKeyboard(inputField: textField)
        return true
    }
}
