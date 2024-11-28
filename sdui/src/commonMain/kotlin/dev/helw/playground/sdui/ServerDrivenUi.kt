/**
 * Copyright (c) 2024 Ahmed El-Helw and Abdulahi Osoble
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */
package dev.helw.playground.sdui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.helw.playground.sdui.model.ServerDrivenUiResponse

@Composable
fun ServerDrivenUi(serverDrivenUiResponse: ServerDrivenUiResponse, modifier: Modifier) {
    serverDrivenUiResponse.root.Content(modifier)
}
