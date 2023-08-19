package dev.helw.playground.sdui.design.core.color

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.staticCompositionLocalOf
import dev.helw.playground.sdui.design.core.TextColor
import dev.helw.playground.sdui.design.theme.md_theme_dark_primary
import dev.helw.playground.sdui.design.theme.md_theme_dark_secondary
import dev.helw.playground.sdui.design.theme.md_theme_light_primary
import dev.helw.playground.sdui.design.theme.md_theme_light_secondary

@Immutable
class TextColors internal constructor(
    val primary: TextColor,
    val secondary: TextColor
)

val LocalTextColors: ProvidableCompositionLocal<TextColors> =
    staticCompositionLocalOf { error("No TextColors provided") }

internal fun lightTextColors(): TextColors = TextColors(
    primary = TextColor(md_theme_light_primary),
    secondary = TextColor(md_theme_light_secondary)
)

internal fun darkTextColors(): TextColors = TextColors(
    primary = TextColor(md_theme_dark_primary),
    secondary = TextColor(md_theme_dark_secondary)
)