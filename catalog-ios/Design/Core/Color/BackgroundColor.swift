//
//  BackgroundColor.swift
//  Catalog
//
//  Created by Ahmed El-Helw on 9/9/23.
//

import SwiftUI

enum BackgroundColor: String, Codable, CaseIterable {
  case primary
  case secondary
  case tertiary
  case onPrimary
  case onSecondary
  case onTertiary
  case error
}

extension BackgroundColor {
  var color: DesignColor {
    switch self {
      case .primary:
        return DesignColor(light: ColorPalette.lightPrimaryContainer, dark: ColorPalette.darkPrimaryContainer)
      case .secondary:
        return DesignColor(light: ColorPalette.lightSecondaryContainer, dark: ColorPalette.darkSecondaryContainer)
      case .tertiary:
        return DesignColor(light: ColorPalette.lightTertiaryContainer, dark: ColorPalette.darkTertiaryContainer)
      case .onPrimary:
        return DesignColor(light: ColorPalette.lightOnPrimaryContainer, dark: ColorPalette.lightPrimaryContainer)
      case .onSecondary:
        return DesignColor(light: ColorPalette.lightOnSecondaryContainer, dark: ColorPalette.lightSecondaryContainer)
      case .onTertiary:
        return DesignColor(light: ColorPalette.lightOnTertiaryContainer, dark: ColorPalette.lightTertiaryContainer)
      case .error:
        return DesignColor(light: ColorPalette.lightError, dark: ColorPalette.darkError)
    }
  }
}
