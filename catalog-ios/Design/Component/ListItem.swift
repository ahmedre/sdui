//
//  ListItem.swift
//  Catalog
//
//  Created by Ahmed El-Helw on 9/10/23.
//

import SwiftUI

struct ListItem: Codable {
  let title: ListItemTitle
  let description: ListItemDescription
  let leading: ListItemLeading
  let trailing: ListItemTrailing
}

extension ListItem: View {
  
  var body: some View {
    HStack {
      leading.body
      VStack(alignment: .leading) {
        title.body
        description.body
      }
      Spacer()
      trailing.body
    }
    .padding([.top, .bottom], 8)
  }
}

#Preview {
  List {
    ListItem(
      title: ListItemTitle(text: "SDUI"),
      description: ListItemDescription(text: "Server Driven UI"),
      leading: .letterCircle("SD", .large, .labelMedium, .primary),
      trailing: .statusIcon(.check, .medium)
    )
    ListItem(
      title: ListItemTitle(text: "SDUI"),
      description: ListItemDescription(text: "Server Driven UI"),
      leading:   .networkImage("https://images.freeimages.com/images/large-previews/8d1/summer-joy-1629829.jpg", .large),
      trailing: .detail("Extra")
    )
  }
}
