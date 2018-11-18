//
//  Helper.swift
//  SnapChef
//
//  Created by Dylan Clarry on 2018-11-17.
//  Copyright © 2018 SnapChefTeam. All rights reserved.
//

import UIKit

class Keyboard {
    // hides keyboard
    static func hideKeyboard(inputField: UITextField) {
        inputField.resignFirstResponder()
    }
}
