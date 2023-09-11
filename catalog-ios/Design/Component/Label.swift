//
//  Label.swift
//  Catalog
//
//  Created by Ahmed El-Helw on 9/8/23.
//

import SwiftUI

struct Label: View, Codable {
  let text: String
  let style: TextStyle
  let color: TextColor
  
  enum CodingKeys: String, CodingKey {
    case text
    case style = "typography"
    case color
  }
  
  var body: some View {
    Text(text)
      .font(style.typography.font)
      .lineSpacing(style.typography.lineSpacing)
      .foregroundColor(color.color.asSwiftUIColor)
  }
}
  
#Preview {
  VStack {
    Label(text: "Headline.Large", style: .headlineLarge, color: .primary)
    Label(text: "Headline.Medium", style: .headlineMedium, color: .secondary)
    Label(text: "Headline.Small", style: .headlineSmall, color: .tertiary)
  }
}
