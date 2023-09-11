//
//  Icon.swift
//  Catalog
//
//  Created by Ahmed El-Helw on 9/9/23.
//

import SwiftUI

struct Icon: View, Codable {
  let token: IconToken
  let size: SizeToken
  
  var body: some View {
    Image(systemName: token.value)
      .font(.system(size: size.value))
  }
}


#Preview {
  VStack {
    HStack {
      Icon(token: .home, size: .small)
      Icon(token: .add, size: .medium)
      Icon(token: .delete, size: .large)
    }
     HStack {
      Icon(token: .favorite, size: .small)
      Icon(token: .settings, size: .medium)
      Icon(token: .list, size: .large)
    }
        HStack {
      Icon(token: .check, size: .small)
      Icon(token: .arrowForward, size: .medium)
      Icon(token: .arrowBackward, size: .large)
    }
    HStack {
      Icon(token: .place, size: .small)
      Icon(token: .info, size: .medium)
      Icon(token: .home, size: .large)
    }
  }
}
