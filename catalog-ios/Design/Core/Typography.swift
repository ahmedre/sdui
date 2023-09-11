//
//  Typography.swift
//  Catalog
//
//  Created by Ahmed El-Helw on 9/8/23.
//

import SwiftUI

struct Typography {
  private let textStyle: Font.TextStyle
  private let weight: Font.Weight
  private let size: CGFloat
  private let lineHeight: CGFloat
  private let letterSpacing: Double
}

extension Typography {
  var font: Font {
    Font.system(size: size, weight: weight)
  }
  
  var lineSpacing: CGFloat {
    lineHeight
  }
}

extension Typography {
  enum Headline {
    static let large = Typography(textStyle: .largeTitle, weight: .semibold, size: 32.0, lineHeight: 40.0, letterSpacing: 0)
    static let medium = Typography(textStyle: .title, weight: .semibold, size: 28.0, lineHeight: 36.0, letterSpacing: 0)
    static let small = Typography(textStyle: .title2, weight: .semibold, size: 24.0, lineHeight: 22.0, letterSpacing: 0)
  }
  
  enum Title {
    static let large = Typography(textStyle: .title3, weight: .medium, size: 22.0, lineHeight: 28.0, letterSpacing: 0)
    static let medium = Typography(textStyle: .headline, weight: .medium, size: 16.0, lineHeight: 24.0, letterSpacing: 0.2)
    static let small = Typography(textStyle: .subheadline, weight: .medium, size: 14.0, lineHeight: 20.0, letterSpacing: 0.1)
  }
  
  enum Body {
    static let large = Typography(textStyle: .body, weight: .medium, size: 18.0, lineHeight: 24.0, letterSpacing: -0.25)
    static let medium = Typography(textStyle: .caption, weight: .medium, size: 16.0, lineHeight: 24.0, letterSpacing: -0.25)
    static let small = Typography(textStyle: .caption2, weight: .medium, size: 14.0, lineHeight: 20.0, letterSpacing: -0.25)
  }
  
  enum Label {
    static let large = Typography(textStyle: .body, weight: .medium, size: 14.0, lineHeight: 20.0, letterSpacing: 0.1)
    static let medium = Typography(textStyle: .caption, weight: .medium, size: 12.0, lineHeight: 16.0, letterSpacing: 0.5)
    static let small = Typography(textStyle: .caption2, weight: .medium, size: 11.0, lineHeight: 16.0, letterSpacing: 0.5)
  }
}
