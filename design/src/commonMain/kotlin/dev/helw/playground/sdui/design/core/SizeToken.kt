package dev.helw.playground.sdui.design.core

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

enum class SizeToken(val underlyingSize: Dp) {
    SMALL(12.dp),
    MEDIUM(16.dp),
    LARGE(24.dp)
}