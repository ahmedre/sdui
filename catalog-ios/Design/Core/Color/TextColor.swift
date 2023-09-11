//
//  TextColor.swift
//  Catalog
//
//  Created by Ahmed El-Helw on 9/9/23.
//

import SwiftUI

enum TextColor: String, Codable, CaseIterable {
  case primary
  case secondary
  case tertiary
  case primaryInverse
}

extension TextColor {
  var color: DesignColor {
    switch self {
      case .primary:
        return DesignColor(light: ColorPalette.lightPrimary, dark: ColorPalette.darkPrimary)
      case .secondary:
        return DesignColor(light: ColorPalette.lightSecondary, dark: ColorPalette.darkSecondary)
      case .tertiary:
        return DesignColor(light: ColorPalette.lightTertiary, dark: ColorPalette.darkTertiary)
      case .primaryInverse:
        return DesignColor(light: ColorPalette.darkPrimary, dark: ColorPalette.lightPrimary)
    }
  }
}
