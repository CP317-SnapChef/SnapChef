//
//  LoginViewController.swift
//  SnapChef
//
//  Created by Dylan Clarry on 2018-11-17.
//  Copyright © 2018 SnapChefTeam. All rights reserved.
//

import UIKit

var username = "dc1324"
var password = "password"

class LoginViewController: UIViewController, UITextFieldDelegate {
    
    // MARK: outlets
    @IBOutlet weak var loginView_UsernameInputField: UITextField!
    @IBOutlet weak var loginView_PasswordInputField: UITextField!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        loginView_UsernameInputField.delegate = self
        loginView_PasswordInputField.delegate = self
        Keyboard.sayHello()
        print(username)
        print(password)
        
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
    @IBAction func loginView_LoginBtn(_ sender: UIButton) {
        Keyboard.hideKeyboard(inputField: loginView_UsernameInputField)
        performSegue(withIdentifier: "segue_Login->Homepage", sender: self)
    }
    
    @IBAction func loginView_SignupBtn(_ sender: UIButton) {
        performSegue(withIdentifier: "segue_Login->Signup", sender: self)
    }
    
    /* unwind segue */
    @IBAction func PrepareUnwindSegue(segue: UIStoryboardSegue) {
        
    }
    
    override func unwind(for unwindSegue: UIStoryboardSegue, towards subsequentVC: UIViewController) {
        let segue = UnwindSegueFromRight(identifier: unwindSegue.identifier, source: unwindSegue.source, destination: unwindSegue.destination)
        segue.perform()
    }
    
    // MARK: functions
    @objc func keyboardWillChange(notification: Notification) {
        let key = "UIKeyboardFrameEndUserInfoKey"
        guard let keyboardRect = (notification.userInfo?[key] as? NSValue)?.cgRectValue else { return }
        
        if notification.name == UIResponder.keyboardWillShowNotification || notification.name == UIResponder.keyboardWillChangeFrameNotification {
            view.frame.origin.y = -keyboardRect.height / 2
        } else {
            view.frame.origin.y = 0
        }
    }
    
    // UITextFieldDelegate functions
    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
        Keyboard.hideKeyboard(inputField: textField)
        return true
    }
}
