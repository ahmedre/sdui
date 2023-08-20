package dev.helw.playground.sdui.design.core

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

enum class SizeToken(val underlyingSize: Dp) {
    SMALL(24.dp),
    MEDIUM(32.dp),
    LARGE(48.dp)
}