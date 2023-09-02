package dev.helw.playground.sdui.design.core.color

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.staticCompositionLocalOf
import dev.helw.playground.sdui.design.core.BackgroundColor
import dev.helw.playground.sdui.design.theme.md_theme_dark_errorContainer
import dev.helw.playground.sdui.design.theme.md_theme_dark_primaryContainer
import dev.helw.playground.sdui.design.theme.md_theme_dark_secondaryContainer
import dev.helw.playground.sdui.design.theme.md_theme_dark_tertiaryContainer
import dev.helw.playground.sdui.design.theme.md_theme_light_errorContainer
import dev.helw.playground.sdui.design.theme.md_theme_light_primaryContainer
import dev.helw.playground.sdui.design.theme.md_theme_light_secondaryContainer
import dev.helw.playground.sdui.design.theme.md_theme_light_tertiaryContainer

@Immutable
class BackgroundColors internal constructor(
    val primary: BackgroundColor,
    val secondary: BackgroundColor,
    val tertiary: BackgroundColor,
    val error: BackgroundColor
)

val LocalBackgroundColors: ProvidableCompositionLocal<BackgroundColors> =
    staticCompositionLocalOf { error("No BackgroundColors provided") }

internal fun lightBackgroundColors(): BackgroundColors = BackgroundColors(
    primary = BackgroundColor(md_theme_light_primaryContainer),
    secondary = BackgroundColor(md_theme_light_secondaryContainer),
    tertiary = BackgroundColor(md_theme_light_tertiaryContainer),
    error = BackgroundColor(md_theme_light_errorContainer),
)

internal fun darkBackgroundColors(): BackgroundColors = BackgroundColors(
    primary = BackgroundColor(md_theme_dark_primaryContainer),
    secondary = BackgroundColor(md_theme_dark_secondaryContainer),
    tertiary = BackgroundColor(md_theme_dark_tertiaryContainer),
    error = BackgroundColor(md_theme_dark_errorContainer),
)

fun BackgroundColors.withNames() = buildList {
    add("primary" to primary)
    add("secondary" to secondary)
    add("tertiary" to tertiary)
    add("error" to error)
}