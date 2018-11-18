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
        
        // delegate textfields
        signupView_UsernameInputField.delegate = self
        signupView_PasswordInputField.delegate = self
        signupView_ConfirmPasswordInputField.delegate = self
    }
    
    // MARK: actions
    
    /* back button */
    @IBAction func signupView_backBtn(_ sender: UIButton) {
        
        // dismiss to login
        performSegue(withIdentifier: "dismissSignupView", sender: self)
    }
    
    /* signup button */
    @IBAction func signupView_SignupBtn(_ sender: UIButton) {
        
        // get username, password, and confirm password textfield values
        let usernameInput: String = signupView_UsernameInputField.text!
        let passwordInput: String = signupView_PasswordInputField.text!
        let confirmPasswordInput: String = signupView_ConfirmPasswordInputField.text!
        
        // check if textfield values are not blank
        if passwordInput != "" && confirmPasswordInput != "" && usernameInput != "" {
            
            // check if passwords match
            if passwordInput == confirmPasswordInput {
                print("equal")
                
                // create new user ***(must change in different context)
                username = usernameInput
                password = passwordInput
                
                // dismiss to login
                performSegue(withIdentifier: "dismissSignupView", sender: self)
            } else {
                // alert if passwords do not match
                Alert.signupAlert(view: self)
            }
        } else {
            // alert if there are empty fields
            Alert.signupAlertBlank(view: self)
        }
        
    }
    
    /* UITextFieldDelegate functions */
    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
        Keyboard.hideKeyboard(inputField: textField)
        return true
    }
}
