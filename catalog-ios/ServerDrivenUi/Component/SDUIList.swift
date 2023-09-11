//
//  SDUIList.swift
//  Catalog
//
//  Created by Ahmed El-Helw on 9/11/23.
//

import SwiftUI

struct SDUIList: View, Decodable {
  let contents: [SDUIDecodableView]
  
  var body: some View {
    List {
      ForEach(0..<contents.count, id: \.self) { index in
        contents[index].body
      }
    }
  }
}
