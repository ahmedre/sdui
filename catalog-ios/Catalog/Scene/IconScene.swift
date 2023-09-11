//
//  IconScene.swift
//  Catalog
//
//  Created by Ahmed El-Helw on 9/10/23.
//

import SwiftUI

struct IconScene: View {
  var body: some View {
    let icons = IconToken.allCases
    List {
      ForEach(0..<icons.count, id: \.self) { value in
        HStack {
          Icon(token: icons[value], size: .small)
          Text(icons[value].rawValue)
        }
      }
    }
  }
}

#Preview {
  IconScene()
}
