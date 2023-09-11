//
//  ColorScene.swift
//  Catalog
//
//  Created by Ahmed El-Helw on 9/10/23.
//

import SwiftUI

struct ColorScene: View {
  var body: some View {
    VStack {
      Label(text: "Background Colors", style: .headlineLarge, color: .primary)
      ScrollView(.horizontal) {
        HStack {
          let colors = BackgroundColor.allCases
          ForEach(0..<colors.count, id: \.self) { index in
            Label(
              text: String(describing: colors[index]),
              style: .bodyMedium,
              color: .tertiary
            )
            .padding()
            .background(colors[index].color.asSwiftUIColor)
          }
        }
      }
      
      Label(text: "Text Colors", style: .headlineLarge, color: .primary)
      ScrollView(.horizontal) {
        HStack {
          let colors = TextColor.allCases
          ForEach(0..<colors.count, id: \.self) { index in
            Text(String(describing: colors[index]))
              .foregroundColor(Color.white)
              .padding()
              .background(colors[index].color.asSwiftUIColor)
          }
        }
      }
    }
  }
}

#Preview {
  ColorScene()
}
