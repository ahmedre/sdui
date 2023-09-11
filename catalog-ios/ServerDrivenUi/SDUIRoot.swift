//
//  SDUIRoot.swift
//  Catalog
//
//  Created by Ahmed El-Helw on 9/10/23.
//

import SwiftUI

struct SDUIRoot: View, Decodable {
  let root: SDUIDecodableView
  let version: Int
  
  var body: some View {
    root
  }
}
