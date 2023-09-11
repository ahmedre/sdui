//
//  ServerDrivenUiScene.swift
//  Catalog
//
//  Created by Ahmed El-Helw on 9/11/23.
//

import SwiftUI

struct ServerDrivenUiScene: View {
  var body: some View {
    let payload = fullSampleJson
    if let data = payload.data(using: .utf8) {
      let decoder = JSONDecoder()
      let content = try? decoder.decode(SDUIRoot.self, from: data)
      if content != nil {
        content
      } else {
        Text("Error")
      }
    }
  }
}

#Preview {
  ServerDrivenUiScene()
}
