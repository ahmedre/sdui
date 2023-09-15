//
//  Column.swift
//  Catalog
//
//  Created by Ahmed El-Helw on 9/15/23.
//

import SwiftUI

struct Column: View, Decodable {
  let contents: [SDUIDecodableView]
  
  var body: some View {
    VStack {
      ForEach(0..<contents.count, id: \.self) { index in
        contents[index].body
      }
    }
  }
}

#Preview {
  Column(contents: [])
}
