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
    var name: String
    var author: String
    var image: String
    
    
    // init(rating: Double, image: UIImage, name: String, author: String){
    // add image once you figure out how to input an image in a sample
    init(name: String, author: String, image: String){
        self.author = author
        self.name = name
        self.image = image
        //var imageView = UIImage(named: image)
    }
}


