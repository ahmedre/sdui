package dev.helw.playground.sdui.design.core.color

internal data class ColorPalette(
    val textColors: TextColors,
    val backgroundColors: BackgroundColors
)

internal fun colorPalette(isDarkTheme: Boolean): ColorPalette {
    return if (isDarkTheme) {
        darkColorPalette()
    } else {
        lightColorPalette()
    }
}

private fun lightColorPalette(): ColorPalette = ColorPalette(
    textColors = lightTextColors(),
    backgroundColors = lightBackgroundColors()
)

private fun darkColorPalette(): ColorPalette = ColorPalette(
    textColors = darkTextColors(),
    backgroundColors = darkBackgroundColors()
)