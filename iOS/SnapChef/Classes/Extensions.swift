//
//  Extensions.swift
//  SnapChef
//
//  Created by Dylan Clarry on 2018-11-19.
//  Copyright © 2018 SnapChefTeam. All rights reserved.
//

import Foundation
import UIKit

extension UIColor {
    
    static let colorDarkBlue = UIColor().colorFromHex("#002239")
    static let colorMuskyBlue = UIColor().colorFromHex("#324D5D")
    static let colorMuskyGrey = UIColor().colorFromHex("#A9BAC4")
    static let colorLightGrey = UIColor().colorFromHex("#EFEAF7")
    static let colorDarkOrange = UIColor().colorFromHex("#FF5C08")
    static let colorOrange = UIColor().colorFromHex("#FF7800")
    static let colorDarkYellow = UIColor().colorFromHex("#FFB300")
    static let colorYellow = UIColor().colorFromHex("#FFC100")
    
    func colorFromHex(_ hex: String) -> UIColor {
        var hexString = hex.trimmingCharacters(in: .whitespacesAndNewlines).uppercased()
        if hexString.hasPrefix("#") {
            hexString.remove(at: hexString.startIndex)
        }
        
        if hexString.count != 6 {
            return UIColor.blue
        }
        
        var rgb : UInt32 = 0
        Scanner(string: hexString).scanHexInt32(&rgb)
        
        return UIColor.init(
            red: CGFloat((rgb & 0xFF0000) >> 16) / 255.0,
            green: CGFloat((rgb & 0x00FF00) >> 8) / 255.0,
            blue: CGFloat(rgb & 0x0000FF) / 255.0,
            alpha: 1.0
        )
    }
}
