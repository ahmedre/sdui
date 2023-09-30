/**
 * Copyright (c) 2023 Ahmed El-Helw and Abdulahi Osoble
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */
package dev.helw.playground.sdui.design.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ProvidedValue
import androidx.compose.runtime.compositionLocalOf
import dev.helw.playground.sdui.design.core.TypographyToken
import dev.helw.playground.sdui.design.core.color.LocalBackgroundColors
import dev.helw.playground.sdui.design.core.color.LocalTextColors
import dev.helw.playground.sdui.design.core.color.colorPalette
import dev.helw.playground.sdui.design.core.color.materialColors


private val typography = Typography(
    // for now, leave defaults for display{Large,Medium,Small}
    headlineLarge = TypographyToken.Headline.Large.textStyle,
    headlineMedium = TypographyToken.Headline.Medium.textStyle,
    headlineSmall = TypographyToken.Headline.Small.textStyle,
    titleLarge = TypographyToken.Title.Large.textStyle,
    titleMedium = TypographyToken.Title.Medium.textStyle,
    titleSmall = TypographyToken.Title.Small.textStyle,
    bodyLarge = TypographyToken.Body.Large.textStyle,
    bodyMedium = TypographyToken.Body.Medium.textStyle,
    bodySmall = TypographyToken.Body.Small.textStyle,
    labelLarge = TypographyToken.Label.Large.textStyle,
    labelMedium = TypographyToken.Label.Medium.textStyle,
    labelSmall = TypographyToken.Label.Small.textStyle
)

private val LocalThemeAlreadyApplied = compositionLocalOf { false }

@Composable
fun AppTheme(
    useDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {

    if (LocalThemeAlreadyApplied.current) {
        content()
    } else {
        val colorPalette = colorPalette(useDarkTheme)
        val materialColors = materialColors(useDarkTheme)

        CompositionLocalProvider(
            LocalTextColors provides colorPalette.textColors,
            LocalBackgroundColors provides colorPalette.backgroundColors,
            LocalThemeAlreadyApplied provides true,
        ) {
            MaterialTheme(
                colorScheme = materialColors,
                typography = typography,
                content = content
            )
        }
    }
}
