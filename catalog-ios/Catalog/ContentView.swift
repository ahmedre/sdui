//
//  ContentView.swift
//  Catalog
//
//  Created by Ahmed El-Helw on 9/8/23.
//

import SwiftUI

struct ContentView: View {
  var body: some View {
    NavigationStack {
      List {
        NavigationLink("Typography") {
          TypographyScene()
        }
        NavigationLink("Icons") {
          IconScene()
        }
        NavigationLink("Sizes") {
          SizeScene()
        }
        NavigationLink("Colors") {
          ColorScene()
        }
        NavigationLink("List") {
          ListScene()
        }
        NavigationLink("Server Driven UI") {
          ServerDrivenUiScene()
        }
      }
      .navigationTitle("CatalogApp")
    }
  }
}

#Preview {
  ContentView()
}
