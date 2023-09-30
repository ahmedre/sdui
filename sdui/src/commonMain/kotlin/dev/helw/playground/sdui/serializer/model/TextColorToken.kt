/**
 * Copyright (c) 2023 Ahmed El-Helw and Abdulahi Osoble
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */
package dev.helw.playground.sdui.serializer.model

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import dev.helw.playground.sdui.design.core.TextColor
import dev.helw.playground.sdui.design.core.color.LocalTextColors
import dev.helw.playground.sdui.design.core.color.TextColors
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class TextColorToken(private val textColor: TextColors.() -> TextColor) {
    @SerialName("primary") PRIMARY(TextColors::primary),
    @SerialName("secondary") SECONDARY(TextColors::secondary),
    @SerialName("tertiary") TERTIARY(TextColors::tertiary),
    @SerialName("primary_inverse") PRIMARY_INVERSE(TextColors::primaryInverse);

    @Composable
    @ReadOnlyComposable
    fun colorValue(): TextColor = LocalTextColors.current.textColor()
}
