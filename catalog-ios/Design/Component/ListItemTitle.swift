//
//  ListItemTitle.swift
//  Catalog
//
//  Created by Ahmed El-Helw on 9/10/23.
//

import SwiftUI

struct ListItemTitle: View, Codable {
  let text: String
  
  var body: some View {
    Label(text: text, style: .titleMedium, color: .primary)
  }
}

#Preview {
  ListItemTitle(text: "Salam")
}
