//
//  ListScene.swift
//  Catalog
//
//  Created by Ahmed El-Helw on 9/10/23.
//

import SwiftUI

struct ListScene: View {
  var body: some View {
    List {
      ForEach(0...50, id: \.self) { number in
        let leading = leadingItem(for: number)
        let trailing = trailingItem(for: number)
        ListItem(title: ListItemTitle(text: "Title \(number)"), description: ListItemDescription(text: "Description \(number)"), leading: leading, trailing: trailing)
      }
    }
  }
}

private func leadingItem(for number: Int) -> ListItemLeading {
  if (number % 3 == 0) {
    ListItemLeading.letterCircle("\(number)", .medium, .labelMedium, .primary)
  } else if (number % 3 == 1) {
    ListItemLeading.networkImage("https://images.freeimages.com/images/large-previews/8d1/summer-joy-1629829.jpg", .medium)
  } else {
    ListItemLeading.statusIcon(.favorite, .medium)
  }
}

private func trailingItem(for number: Int) -> ListItemTrailing {
  if (number % 2 == 0) {
    ListItemTrailing.detail("\(number)")
  } else {
    ListItemTrailing.statusIcon(.arrowForward, .medium)
  }
}

#Preview {
  ListScene()
}
