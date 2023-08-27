package dev.helw.playground.sdui.design.core

import androidx.compose.ui.graphics.Color
import kotlin.jvm.JvmInline

sealed interface ColorToken {
    val color: Color
}

@JvmInline
value class TextColor internal constructor(override val color: Color) : ColorToken

@JvmInline
value class BackgroundColor internal constructor(override val color: Color) : ColorToken {
    companion object {
        val Unspecified = BackgroundColor(Color.Unspecified)
    }
}