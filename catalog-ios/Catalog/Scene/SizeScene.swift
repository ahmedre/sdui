//
//  SizeScene.swift
//  Catalog
//
//  Created by Ahmed El-Helw on 9/10/23.
//

import SwiftUI

struct SizeScene: View {
  var body: some View {
    VStack(spacing: 10) {
      Icon(token: .home, size: .small)
      Label(text: "Small", style: .bodyLarge, color: .primary)
      Icon(token: .home, size: .medium)
      Label(text: "Medium", style: .bodyLarge, color: .primary)
      Icon(token: .home, size: .large)
      Label(text: "Large", style: .bodyLarge, color: .primary)
    }
  }
}

#Preview {
  SizeScene()
}
