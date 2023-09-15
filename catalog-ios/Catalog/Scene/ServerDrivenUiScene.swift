//
//  ServerDrivenUiScene.swift
//  Catalog
//
//  Created by Ahmed El-Helw on 9/11/23.
//

import SwiftUI
import Combine

@MainActor final class ContentViewModel: ObservableObject {
  @Published var dynamicModel: SDUIRoot
  private var cancellables = Set<AnyCancellable>()
  
  init() {
    let decoder = JSONDecoder()
    dynamicModel = try! decoder.decode(SDUIRoot.self, from: jsonData)
  }
  
  func fetchUI(url: String) {
    URLSession.shared
      .dataTaskPublisher(for: URL(string: url)!)
      .tryMap { (data, _) in
        let decoder = JSONDecoder()
        let model = try decoder.decode(SDUIRoot.self, from: data)
        return model
      }
      .catch { _ in
        let decoder = JSONDecoder()
        let model = try! decoder.decode(SDUIRoot.self, from: errorJsonData)
        return Just(model)
      }
      .receive(on: RunLoop.main)
      .sink { model in
        self.dynamicModel = model
      }
      .store(in: &cancellables)
  }
}

private let jsonData = """
{
  "version": 1,
  "root": {
    "type": "label",
    "id": "loading-label",
    "text": "Salam Droidcon!",
    "typography": "Body.Medium",
    "color": "primary"
  }
}
""".data(using: .utf8)!

private let errorJsonData = """
{
  "version": 1,
  "root": {
    "type": "label",
    "id": "error-label",
    "text": "Failed to parse response!",
    "typography": "Body.Medium",
    "color": "tertiary"
  }
}
""".data(using: .utf8)!


struct ServerDrivenUiScene: View {
  @State private var url: String = "http://localhost:8000/response.json"
  @StateObject var viewModel = ContentViewModel()

  var body: some View {
    VStack {
      TextField("url", text: $url)
        .textFieldStyle(.roundedBorder)
      Button("Refresh") {
        viewModel.fetchUI(url: url)
      }
    }
    
    viewModel.dynamicModel
      .frame(maxHeight: .infinity)
  }
}

#Preview {
  ServerDrivenUiScene()
}
