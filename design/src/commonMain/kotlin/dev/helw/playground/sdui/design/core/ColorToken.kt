/**
 * Copyright (c) 2024 Ahmed El-Helw and Abdulahi Osoble
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */
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
