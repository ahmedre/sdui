//
//  IconToken.swift
//  Catalog
//
//  Created by Ahmed El-Helw on 9/9/23.
//

import Foundation

enum IconToken : String, Codable, CaseIterable {
  case home
  case add
  case delete
  case favorite
  case settings
  case list
  case check
  case arrowForward
  case arrowBackward
  case place
  case info
}

extension IconToken {
  var value: String {
    switch self {
      case .home:
        "house.fill"
      case .add:
        "plus"
      case .delete:
        "trash.fill"
      case .favorite:
        "heart.fill"
      case .settings:
        "gearshape.fill"
      case .list:
        "list.bullet"
      case .check:
        "checkmark"
      case .arrowForward:
        "arrow.forward"
      case .arrowBackward:
        "arrow.backward"
      case .place:
        "mappin"
      case .info:
        "info.circle.fill"
    }
  }
}
