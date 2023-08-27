package dev.helw.playground.sdui.model

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

actual interface Renderer {
    @Composable
    fun Content(modifier: Modifier)
}