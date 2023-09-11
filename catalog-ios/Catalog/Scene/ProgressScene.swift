//
//  ProgressScene.swift
//  Catalog
//
//  Created by Ahmed El-Helw on 9/10/23.
//

import SwiftUI

struct ProgressScene: View {
  var body: some View {
    VStack(spacing: 48) {
      ProgressStatus(amount: 2, total: 10, size: .small)
      ProgressStatus(amount: 4, total: 10, size: .medium)
      ProgressStatus(amount: 6, total: 10, size: .large)
    }
  }
}

#Preview {
  ProgressScene()
}
