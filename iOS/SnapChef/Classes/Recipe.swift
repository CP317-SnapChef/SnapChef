//
//  Recipe.swift
//  SnapChef
//
//  Created by Bryan Mietkiewicz on 2018-11-17.
//  Copyright © 2018 SnapChefTeam. All rights reserved.
//

import Foundation
import UIKit
class Recipe{
    var rating: Double
    var name: String
    var author: String
    var image: String
    
    
    // constructor
    init(name: String, author: String, image: String, rating: Double){
        self.author = author
        self.name = name
        self.image = image
        self.rating = rating
    }
}


