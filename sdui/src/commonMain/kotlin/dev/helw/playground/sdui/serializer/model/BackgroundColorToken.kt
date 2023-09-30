/**
 * Copyright (c) 2023 Ahmed El-Helw and Abdulahi Osoble
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */
package dev.helw.playground.sdui.serializer.model

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import dev.helw.playground.sdui.design.core.BackgroundColor
import dev.helw.playground.sdui.design.core.color.BackgroundColors
import dev.helw.playground.sdui.design.core.color.LocalBackgroundColors
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class BackgroundColorToken(private val backgroundColor: BackgroundColors.() -> BackgroundColor) {
    @SerialName("primary") PRIMARY(BackgroundColors::primary),
    @SerialName("secondary") SECONDARY(BackgroundColors::secondary),
    @SerialName("tertiary") TERTIARY(BackgroundColors::tertiary),
    @SerialName("error") ERROR(BackgroundColors::error);

    @Composable
    @ReadOnlyComposable
    fun colorValue(): BackgroundColor = LocalBackgroundColors.current.backgroundColor()
}
