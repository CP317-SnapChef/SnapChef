
//
//  ReportErrorViewController.swift
//  SnapChef
//
//  Created by Dylan Clarry on 2018-11-19.
//  Copyright © 2018 SnapChefTeam. All rights reserved.
//

import UIKit

class ReportErrorViewController: UIViewController {
    
    // MARK: outlets
    @IBOutlet weak var reportError_TextField: UITextView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        reportError_TextField.layer.borderWidth = 1
        reportError_TextField.layer.borderColor = UIColor.colorMuskyGrey.cgColor
        reportError_TextField.layer.cornerRadius = 6
    }
    
    // MARK: functions
    
    // MARK: actions
}
