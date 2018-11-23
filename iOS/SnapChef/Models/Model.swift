
//
//  TestModel.swift
//  SnapChef
//
//  Created by Dylan Clarry on 2018-11-17.
//  Copyright © 2018 SnapChefTeam. All rights reserved.
//

import UIKit
import CoreData

class Model {
    // set user
    static func setUser() {
        
        // reference AppDelegate
        guard let appDelegate = UIApplication.shared.delegate as? AppDelegate else { return }
        let context = appDelegate.persistentContainer.viewContext
        let userEntity = NSEntityDescription.entity(forEntityName: "User", in: context)!
        
        let newUser = NSManagedObject(entity: userEntity, insertInto: context)
        
        newUser.setValue("dc1324", forKey: "username")
        newUser.setValue("gg", forKey: "password")
        
        do {
            try context.save()
            print("SAVED")
        } catch let error as NSError {
            // PROCESS ERROR
            print("Could not save. \(error), \(error.userInfo)")
        }
    }
}
