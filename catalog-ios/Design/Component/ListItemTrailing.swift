//
//  ListItemTrailing.swift
//  Catalog
//
//  Created by Ahmed El-Helw on 9/10/23.
//

import SwiftUI

enum ListItemTrailing {
  case detail(String)
  case statusIcon(IconToken, SizeToken)
  
  struct Detail: Codable {
    let text: String
  }
  
  struct StatusIcon: Codable {
    let icon: IconToken
    let size: SizeToken
  }
}

extension ListItemTrailing: View {
  
  var body: some View {
    switch self {
      case .detail(let text):
        Label(text: text, style: .labelLarge, color: .tertiary)
      case .statusIcon(let icon, let size):
        Icon(token: icon, size: size)
    }
  }
}

extension ListItemTrailing: Codable {
  private enum CodingKeys: String, CodingKey {
    case type = "type"
  }
  
  init(from decoder: Decoder) throws {
    let container = try decoder.container(keyedBy: CodingKeys.self)
    let type = try container.decode(String.self, forKey: .type)
    let singleContainer = try decoder.singleValueContainer()
    if type == "detail" {
      let data = try singleContainer.decode(Detail.self)
      self = .detail(data.text)
    } else if type == "statusIcon" {
      let data = try singleContainer.decode(StatusIcon.self)
      self = .statusIcon(data.icon, data.size)
    } else {
      throw DecodingError.dataCorruptedError(in: singleContainer, debugDescription: "Error decoding ListItemLeading")
    }
  }
  
  func encode(to encoder: Encoder) throws {
    var container = encoder.singleValueContainer()
    
    switch self {
      case .detail(let text):
        let data = Detail(text: text)
        try container.encode(data)
      case .statusIcon(let icon, let size):
        let data = StatusIcon(icon: icon, size: size)
        try container.encode(data)
    }
  }
}

#Preview {
  VStack {
    ListItemTrailing.detail("detail")
    ListItemTrailing.statusIcon(.check, .small)
  }
}
