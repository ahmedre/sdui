package dev.helw.playground.sdui.design.core.color

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.staticCompositionLocalOf
import dev.helw.playground.sdui.design.core.BackgroundColor
import dev.helw.playground.sdui.design.theme.md_theme_dark_primaryContainer
import dev.helw.playground.sdui.design.theme.md_theme_dark_secondaryContainer
import dev.helw.playground.sdui.design.theme.md_theme_light_primaryContainer
import dev.helw.playground.sdui.design.theme.md_theme_light_secondaryContainer

@Immutable
class BackgroundColors internal constructor(
    val primary: BackgroundColor,
    val secondary: BackgroundColor
)

val LocalBackgroundColors: ProvidableCompositionLocal<BackgroundColors> =
    staticCompositionLocalOf { error("No BackgroundColors provided") }

internal fun lightBackgroundColors(): BackgroundColors = BackgroundColors(
    primary = BackgroundColor(md_theme_light_primaryContainer),
    secondary = BackgroundColor(md_theme_light_secondaryContainer)
)

internal fun darkBackgroundColors(): BackgroundColors = BackgroundColors(
    primary = BackgroundColor(md_theme_dark_primaryContainer),
    secondary = BackgroundColor(md_theme_dark_secondaryContainer)
)