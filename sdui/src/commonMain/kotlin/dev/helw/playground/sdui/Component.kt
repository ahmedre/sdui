package dev.helw.playground.sdui

import androidx.compose.runtime.Composable

interface Component {
    val type: String

    @Composable fun asComposable()
}