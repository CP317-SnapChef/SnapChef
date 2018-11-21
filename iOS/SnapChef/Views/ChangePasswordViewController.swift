
//
//  ChangePasswordViewController.swift
//  SnapChef
//
//  Created by Dylan Clarry on 2018-11-19.
//  Copyright © 2018 SnapChefTeam. All rights reserved.
//

import UIKit

class ChangePasswordViewController: UIViewController, UITextFieldDelegate {
    
    // MARK: outlets
    @IBOutlet weak var changePasswordView_OldPassword: UITextField!
    @IBOutlet weak var changePasswordView_NewPassword: UITextField!
    @IBOutlet weak var changePasswordView_ConfirmPassword: UITextField!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        // delegate text fields
        changePasswordView_OldPassword.delegate = self
        changePasswordView_NewPassword.delegate = self
        changePasswordView_ConfirmPassword.delegate = self
    }
    
    // MARK: functions
    
    /* UITextFieldDelegate functions */
    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
        Keyboard.hideKeyboard(inputField: textField)
        return true
    }
    
    // MARK: actions
    
    /* change password button */
    @IBAction func changePasswordView_ChangePasswordBtn(_ sender: Any) {
        
        // get username, password, and confirm password textfield values
        let oldPassword: String = changePasswordView_OldPassword.text!
        let newPassword: String = changePasswordView_NewPassword.text!
        let confirmPassword: String = changePasswordView_ConfirmPassword.text!
        
        // check if textfield values are not blank
        if oldPassword != "" && newPassword != "" && confirmPassword != "" {
            
            // check if passwords match
            if newPassword == confirmPassword {
                print("equal")
                
                if oldPassword == newPassword {
                    Alert.samePassword(view: self)
                } else {
                    // set password to new password ***(must change in different context)
                    password = newPassword
                    
                    // dismiss to login
                    performSegue(withIdentifier: "dismissChangePasswordView", sender: self)
                }
            } else {
                // alert if passwords do not match
                Alert.signupAlert(view: self)
            }
        } else {
            // alert if there are empty fields
            Alert.signupAlertBlank(view: self)
        }
    }
}
