//
//  DesignColor.swift
//  Catalog
//
//  Created by Ahmed El-Helw on 9/9/23.
//

import SwiftUI

struct DesignColor {
  private let uiColor: UIColor
  private let lightValue: UInt64
  private let darkValue: UInt64
  
  init(light: ColorPalette, dark: ColorPalette, alpha: CGFloat = 1.0) {
    uiColor = UIColor {
      $0.userInterfaceStyle == .dark ?
      makeColor(from: dark.rawValue, alpha: alpha) :
      makeColor(from: light.rawValue, alpha: alpha)
    }
    lightValue = light.rawValue
    darkValue = dark.rawValue
  }
}

extension DesignColor {
  var asSwiftUIColor: Color {
    Color(uiColor)
  }
}

private func makeColor(from hex: UInt64, alpha: CGFloat) -> UIColor {
  let r = CGFloat((hex & 0xff00000) >> 16) / 255.0
  let g = CGFloat((hex & 0x00ff00) >> 8) / 255.0
  let b = CGFloat(hex & 0x0000ff) / 255.0
  return UIColor(red: r, green: g, blue: b, alpha: alpha)
}
