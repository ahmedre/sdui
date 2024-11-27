/**
 * Copyright (c) 2024 Ahmed El-Helw and Abdulahi Osoble
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */
package dev.helw.playground.sdui

import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import dev.helw.playground.sdui.design.theme.AppTheme

fun main() = application {
    Window(
        state = rememberWindowState(size = DpSize(1280.dp, 800.dp)),
        title = "SDUI Demo",
        onCloseRequest = ::exitApplication,
    ) {
        AppTheme { FullScreenDemo() }
    }
}
