//
//  ListItemDescription.swift
//  Catalog
//
//  Created by Ahmed El-Helw on 9/10/23.
//

import SwiftUI

struct ListItemDescription: View, Codable {
  let text: String
  
  var body: some View {
    Label(text: text, style: .labelMedium, color: .secondary)
  }
}

#Preview {
  ListItemDescription(text: "Salam")
}
