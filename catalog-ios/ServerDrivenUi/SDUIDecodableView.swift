//
//  SDUIDecodableView.swift
//  Catalog
//
//  Created by Ahmed El-Helw on 9/10/23.
//

import SwiftUI

struct SDUIDecodableView: View, Decodable {
  private enum CodingKeys: String, CodingKey {
    case viewType = "type"
  }
  
  let view: any View
  
  init(from decoder: Decoder) throws {
    let container = try decoder.container(keyedBy: CodingKeys.self)
    let singleContainer = try decoder.singleValueContainer()
    let type = try container.decode(String.self, forKey: .viewType)
    guard let viewType = viewTypeMapping[type] else {
      fatalError("could not find \(type)")
    }
    view = try singleContainer.decode(viewType)
  }
  
  var body: some View {
    AnyView(view)
  }
}

private let viewTypeMapping: [String: any (View & Decodable).Type] = [
  "list": SDUIList.self,
  "label": Label.self,
  "icon": Icon.self,
  "listItem": ListItem.self,
  "progressStatus": ProgressStatus.self
]
