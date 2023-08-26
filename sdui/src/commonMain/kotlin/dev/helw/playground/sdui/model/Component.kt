package dev.helw.playground.sdui.model

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

interface Component {
    val identifier: String

    @Composable fun Content(modifier: Modifier)
}