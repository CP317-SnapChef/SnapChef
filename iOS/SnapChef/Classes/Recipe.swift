//
//  Recipe.swift
//  SnapChef
//
//  Created by Bryan Mietkiewicz on 2018-11-17.
//  Copyright © 2018 SnapChefTeam. All rights reserved.
//

import Foundation
import UIKit

var recipes = [Recipe]()

// test
func testRecipes() {
    let d1 = "Its just soup, you can't possibly mess this up. If you do I feel sorry for you... Wait, no this is ramen tough luck"
    let ing1 = ["2 Chicken Breasts", "1 Cup of Noodles", "1 Dash Soup", "A Large amount of Salt"]
    let inst1 = ["Cook the Chicken", "Cook the noodles", "saute and add soup"]
    
    let d2 = "\"Burnt toast and a rotten egg?\" \"I've got a tapeworm and it's good enough for him\""
    let ing2 = ["Toast", "Rotten Egg"]
    let inst2 = ["\"accidentally\" burn the toast", "cook rotten egg", "serve together"]
    
    let d3 = "Nowadays, everybody would like to talk as if to infer that they obtain information of great importance, but the act of speaking itself leaves no substantial impact in its current context. Instead, a hollow impression guised by clever diction conceals ones true intent, to portray a character who is seemingly absentminded of the fact that sir Andre Romelle Young is a talented, driven, and relevent individual which may metaphorically denote the destruction of ones false demeanor and exposing a sense of insecurity."
    let ing3 = ["2 beets solos", "1 beets studio", "5 beets pills", "1 m&m(s)"]
    let inst3 = ["Go to university", "Acquire a high paying job in tech", "Buy expensive headphones and serve"]

    recipes += [Recipe(rating: 5.0, name: "Beef Ramen", author: "Dylan Clarry", image: "beeframen", cookTime: 360, prepTime: 126, description: d1, serves: 2, ingredients: ing1, instructions: inst1)]
    recipes += [Recipe(rating: 1.4, name: "Beets", author: "Dr. Dre", image: "beets", cookTime: 560, prepTime: 127, description: d3, serves: 20, ingredients: ing3, instructions: inst3)]
    recipes += [Recipe(rating: 1.0, name: "Burnt toast and a rotten egg", author: "Bryan Mietkiewicz", image: "burnttoast", cookTime: 20, prepTime: 2, description: d2, serves: 3, ingredients: ing2, instructions: inst2)]
    recipes += [Recipe(rating: 3.4, name: "Turducken", author: "Anonymous", cookTime: 121)]
    recipes += [Recipe(rating: 3.4, name: "Turducken", author: "Anonymous", cookTime: 121)]
}

class Recipe{
    var rating: Double
    var name: String
    var author: String
    var image = "missing"
    var prepTime = 0
    var cookTime: Int
    var description = "No description Available"
    var serves = 1
    var ingredients = ["no ingredients inputted"]
    var instructions = ["no instructions inputted"]
    

    init(rating: Double, name: String, author: String, image: String, cookTime: Int, prepTime: Int, description: String, serves: Int, ingredients: [String], instructions: [String]){
        self.rating = rating
        self.author = author
        self.name = name
        self.image = image
        self.prepTime = prepTime
        self.cookTime = cookTime
        self.description = description
        self.serves = serves
        self.ingredients = ingredients
        self.instructions = instructions
    }
    init(rating: Double, name: String, author: String, cookTime: Int){
        self.rating = rating
        self.author = author
        self.name = name
        self.cookTime = cookTime
    }
}
