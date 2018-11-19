//
//  LoginViewController.swift
//  SnapChef
//
//  Created by Dylan Clarry on 2018-11-17.
//  Copyright © 2018 SnapChefTeam. All rights reserved.
//

import UIKit

var username = ""
var password = ""

class LoginViewController: UIViewController, UITextFieldDelegate {
    
    // MARK: outlets
    @IBOutlet weak var loginView_UsernameInputField: UITextField!
    @IBOutlet weak var loginView_PasswordInputField: UITextField!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        
        // delegate textfields
        loginView_UsernameInputField.delegate = self
        loginView_PasswordInputField.delegate = self
        
        // keyboard listen events
        NotificationCenter.default.addObserver(self, selector: #selector(keyboardWillChange(notification:)), name: UIResponder.keyboardWillShowNotification, object: nil)
        NotificationCenter.default.addObserver(self, selector: #selector(keyboardWillChange(notification:)), name: UIResponder.keyboardWillHideNotification, object: nil)
        NotificationCenter.default.addObserver(self, selector: #selector(keyboardWillChange(notification:)), name: UIResponder.keyboardWillChangeFrameNotification, object: nil)
    }
    
    deinit {
        
        // stop keyboard listen events
        NotificationCenter.default.removeObserver(self, name: UIResponder.keyboardWillShowNotification, object: nil)
        NotificationCenter.default.removeObserver(self, name: UIResponder.keyboardWillHideNotification, object: nil)
        NotificationCenter.default.removeObserver(self, name: UIResponder.keyboardWillChangeFrameNotification, object: nil)
    }
    
    // MARK: actions
    
    /* login button */
    @IBAction func loginView_LoginBtn(_ sender: UIButton) {
        testRecipes()
        
        // hide keyboard
        Keyboard.hideKeyboard(inputField: loginView_UsernameInputField)
        
        // get username and password textfield values
        let usernameInput: String = loginView_UsernameInputField.text!
        let passwordInput: String = loginView_PasswordInputField.text!
        
        // check if login credentials are correct
        if usernameInput == username && passwordInput == password {
            performSegue(withIdentifier: "segue_Login->Homepage", sender: self)
        } else {
            // alert if login credentials are incorrect
            Alert.loginAlert(view: self)
        }
    }
    
    /* signup button */
    @IBAction func loginView_SignupBtn(_ sender: UIButton) {
        
        // hide keyboard
        Keyboard.hideKeyboard(inputField: loginView_UsernameInputField)
        performSegue(withIdentifier: "segue_Login->Signup", sender: self)
    }
    
    
    // MARK: functions
    
    /* dismiss from signup view */
    @IBAction func dismissSignupView(segue: UIStoryboardSegue) { }
    
    /* keyboard height adjustments */
    @objc func keyboardWillChange(notification: Notification) {
        let key = "UIKeyboardFrameEndUserInfoKey"
        guard let keyboardRect = (notification.userInfo?[key] as? NSValue)?.cgRectValue else { return }
        
        // adjust to height of keyboard
        if notification.name == UIResponder.keyboardWillShowNotification || notification.name == UIResponder.keyboardWillChangeFrameNotification {
            view.frame.origin.y = -keyboardRect.height / 2
        } else {
            // reset height from keyboard
            view.frame.origin.y = 0
        }
    }
    
    // UITextFieldDelegate functions
    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
        Keyboard.hideKeyboard(inputField: textField)
        return true
    }
}
