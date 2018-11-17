//
//  Helper.swift
//  SnapChef
//
//  Created by Dylan Clarry on 2018-11-17.
//  Copyright © 2018 SnapChefTeam. All rights reserved.
//

import UIKit

class Keyboard {
    static func sayHello() {
        print("hello from Keyboard")
    }
    
    static func hideKeyboard(inputField: UITextField) {
        inputField.resignFirstResponder()
    }
}
