//
//  ListItemLeading.swift
//  Catalog
//
//  Created by Ahmed El-Helw on 9/10/23.
//

import SwiftUI

enum ListItemLeading {
  case letterCircle(String, SizeToken, TextStyle, BackgroundColor)
  case networkImage(String, SizeToken)
  case statusIcon(IconToken, SizeToken)
  
  struct LetterCircle: Codable {
    let text: String
    let size: SizeToken
    let typography: TextStyle
    let backgroundColor: BackgroundColor
  }
  
  struct NetworkImage: Codable {
    let url: String
    let size: SizeToken
  }
  
  struct StatusIcon: Codable {
    let icon: IconToken
    let size: SizeToken
  }
}

extension ListItemLeading: View {
  
  var body: some View {
    switch self {
      case .letterCircle(let text, let size, let textStyle, let color):
        Label(text: text, style: textStyle, color: .primary)
          .padding()
          .background(
            Circle()
              .fill(color.color.asSwiftUIColor)
              .frame(width: size.value, height: size.value)
          )
          .frame(width: size.value, height: size.value)
      case .networkImage(let url, let size):
        AsyncImage(url: URL(string: url)) { image in
          image.image?.resizable()
            .aspectRatio(contentMode: .fit)
            .frame(width: size.value, height: size.value)
        }
        .background()
        .frame(width: size.value, height: size.value)
      case .statusIcon(let icon, let size):
        Icon(token: icon, size: size)
          .frame(width: size.value, height: size.value)
    }
  }
}

extension ListItemLeading: Codable {
  private enum CodingKeys: String, CodingKey {
    case type = "type"
  }
  
  init(from decoder: Decoder) throws {
    let container = try decoder.container(keyedBy: CodingKeys.self)
    let type = try container.decode(String.self, forKey: .type)
    let singleContainer = try decoder.singleValueContainer()
    if type == "letterCircle" {
      let data = try singleContainer.decode(LetterCircle.self)
      self = .letterCircle(data.text, data.size, data.typography, data.backgroundColor)
    } else if type == "networkImage" {
      let data = try singleContainer.decode(NetworkImage.self)
      self = .networkImage(data.url, data.size)
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
      case .letterCircle(let text, let size, let typography, let backgroundColor):
        let data = LetterCircle(text: text, size: size, typography: typography, backgroundColor: backgroundColor)
        try container.encode(data)
      case .networkImage(let url, let size):
        let data = NetworkImage(url: url, size: size)
        try container.encode(data)
      case .statusIcon(let icon, let size):
        let data = StatusIcon(icon: icon, size: size)
        try container.encode(data)
    }
  }
}

#Preview {
  VStack {
    ListItemLeading.letterCircle("AE", .large, .labelMedium, .primary)
    ListItemLeading.networkImage("https://images.freeimages.com/images/large-previews/8d1/summer-joy-1629829.jpg", .large)
    ListItemLeading.statusIcon(.settings, .medium)
  }
}
