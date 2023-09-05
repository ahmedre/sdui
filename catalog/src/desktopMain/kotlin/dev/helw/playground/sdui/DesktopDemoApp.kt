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