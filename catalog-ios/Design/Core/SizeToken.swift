//
//  SizeToken.swift
//  Catalog
//
//  Created by Ahmed El-Helw on 9/9/23.
//

import Foundation

enum SizeToken : String, Codable {
  case small
  case medium
  case large
}

extension SizeToken {
  var value: CGFloat {
    switch self {
      case .small:
        24
      case .medium:
        32
      case .large:
        48
    }
  }
}
