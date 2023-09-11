//
//  TextStyle.swift
//  Catalog
//
//  Created by Ahmed El-Helw on 9/10/23.
//

import SwiftUI

enum TextStyle: String, Codable, CaseIterable {
  case headlineSmall = "Headline.Small"
  case headlineMedium = "Headline.Medium"
  case headlineLarge = "Headline.Large"
  case titleSmall = "Title.Small"
  case titleMedium = "Title.Medium"
  case titleLarge = "Title.Large"
  case bodySmall = "Body.Small"
  case bodyMedium = "Body.Medium"
  case bodyLarge = "Body.Large"
  case labelSmall = "Label.Small"
  case labelMedium = "Label.Medium"
  case labelLarge = "Label.Large"
}

extension TextStyle {
  var typography: Typography {
    switch self {
      case .headlineSmall:
        Typography.Headline.small
      case .headlineMedium:
        Typography.Headline.medium
      case .headlineLarge:
        Typography.Headline.large
      case .titleSmall:
        Typography.Title.small
      case .titleMedium:
        Typography.Title.medium
      case .titleLarge:
        Typography.Title.large
      case .bodySmall:
        Typography.Body.small
      case .bodyMedium:
        Typography.Body.medium
      case .bodyLarge:
        Typography.Body.large
      case .labelSmall:
        Typography.Label.small
      case .labelMedium:
        Typography.Label.medium
      case .labelLarge:
        Typography.Label.large
    }
  }
}
