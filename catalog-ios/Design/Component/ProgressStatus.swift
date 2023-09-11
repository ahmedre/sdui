//
//  ProgressStatus.swift
//  Catalog
//
//  Created by Ahmed El-Helw on 9/10/23.
//

import SwiftUI

struct ProgressStatus: Codable {
  let amount: Int
  let total: Int
  let size: SizeToken
  var textStyle: TextStyle {
    switch size {
      case .small:
          .labelSmall
      case .medium:
          .labelMedium
      case .large:
          .labelLarge
    }
  }
}

extension ProgressStatus: View {
  
  var body: some View {
    ZStack {
      Circle()
        .stroke(BackgroundColor.tertiary.color.asSwiftUIColor, lineWidth: 8)
        .frame(width: size.value * 2, height: size.value * 2)
      Circle()
        .trim(from: 0, to: (CGFloat(amount) / CGFloat(total)))
        .rotation(.degrees(-90))
        .stroke(
          BackgroundColor.onTertiary.color.asSwiftUIColor,
          style: StrokeStyle(lineWidth: 8, lineCap: .butt)
        )
        .frame(width: size.value * 2, height: size.value * 2)
      Label(text: "\(amount)/\(total)", style: textStyle, color: .primary)
    }
  }
}

#Preview {
  ProgressStatus(amount: 2, total: 10, size: .large)
}
