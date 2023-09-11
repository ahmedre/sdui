//
//  TypographyScene.swift
//  Catalog
//
//  Created by Ahmed El-Helw on 9/10/23.
//

import SwiftUI

struct TypographyScene: View {
  var body: some View {
    VStack {
      Label(text: "Headline.Large", style: .headlineLarge, color: .primary)
      Label(text: "Headline.Medium", style: .headlineMedium, color: .secondary)
      Label(text: "Headline.Small", style: .headlineSmall, color: .tertiary)
      
      Label(text: "Title.Large", style: .titleLarge, color: .primary)
      Label(text: "Title.Medium", style: .titleMedium, color: .secondary)
      Label(text: "Title.Small", style: .titleSmall, color: .tertiary)
      
      Label(text: "Body.Large", style: .bodyLarge, color: .primary)
      Label(text: "Body.Medium", style: .bodyMedium, color: .secondary)
      Label(text: "Body.Small", style: .bodySmall, color: .tertiary)
      
      Label(text: "Label.Large", style: .labelLarge, color: .primary)
      Label(text: "Label.Medium", style: .labelMedium, color: .primaryInverse)
      Label(text: "Label.Small", style: .labelSmall, color: .secondary)
    }
  }
}

#Preview {
  TypographyScene()
}
