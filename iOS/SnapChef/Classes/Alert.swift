
//
//  Alerts.swift
//  SnapChef
//
//  Created by Dylan Clarry on 2018-11-17.
//  Copyright © 2018 SnapChefTeam. All rights reserved.
//

import UIKit

class Alert {
    // alert for login view
    static func loginAlert(view: UIViewController) {
        let alert = UIAlertController(title: "Invalid login.", message: "The username or password you entered is incorrect.", preferredStyle: .alert)
        alert.addAction(UIAlertAction(title: "Ok", style: .default, handler: nil))
        view.present(alert, animated: true)
    }
    
    // alert for signup view
    static func signupAlert(view: UIViewController) {
        let alert = UIAlertController(title: "Invalid.", message: "Passwords do not match.", preferredStyle: .alert)
        alert.addAction(UIAlertAction(title: "Ok", style: .default, handler: nil))
        view.present(alert, animated: true)
    }
    
    // alert for signup view blank
    static func signupAlertBlank(view: UIViewController) {
        let alert = UIAlertController(title: "Invalid.", message: "Empty fields.", preferredStyle: .alert)
        alert.addAction(UIAlertAction(title: "Ok", style: .default, handler: nil))
        view.present(alert, animated: true)
    }
}
