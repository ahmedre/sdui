package dev.helw.playground.sdui.design.core

import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

internal expect val fontFamily: FontFamily

internal expect val platformTextStyle: PlatformTextStyle

private inline val DefaultFontFamily: FontFamily get() = fontFamily

private inline val DefaultPlatformTextStyle: PlatformTextStyle get() = platformTextStyle

sealed class TypographyToken(val name: String, val textStyle: TextStyle) {
    sealed class Headline(name: String, textStyle: TextStyle) : TypographyToken(name, textStyle) {
        data object Large : Headline("Headline.Large", TextStyle())
        data object Medium : Headline("Headline.Medium", TextStyle())
        data object Small : Headline("Headline.Small", TextStyle())
    }

    sealed class Title(name: String, textStyle: TextStyle) : TypographyToken(name, textStyle) {
        data object Large : Title("Title.Large", TextStyle())
        data object Medium : Title("Title.Medium", TextStyle())
        data object Small : Title("Title.Small", TextStyle())
    }

    sealed class Body(name: String, textStyle: TextStyle) : TypographyToken(name, textStyle) {
        data object Large : Body(
            name = "Body.Large",
            textStyle = TextStyle(
                fontFamily = DefaultFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 18.sp,
                lineHeight = 24.sp,
                letterSpacing = (-0.25).sp,
                platformStyle = DefaultPlatformTextStyle,
            )
        )

        data object Medium : Body(
            name = "Body.Medium",
            textStyle = TextStyle(
                fontFamily = DefaultFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                lineHeight = 24.sp,
                letterSpacing = (-0.25).sp,
                platformStyle = DefaultPlatformTextStyle,
            )
        )

        data object Small : Body(
            name = "Body.Small",
            textStyle = TextStyle(
                fontFamily = DefaultFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                lineHeight = 20.sp,
                letterSpacing = (-0.25).sp,
                platformStyle = DefaultPlatformTextStyle,
            ),
        )
    }

    sealed class Label(name: String, textStyle: TextStyle) : TypographyToken(name, textStyle) {
        data object Large : Label("Label.Large", TextStyle())
        data object Medium : Label("Label.Medium", TextStyle())
        data object Small : Label("Label.Small", TextStyle())
        data object Detail : Label("Label.Detail", TextStyle())
    }

    companion object {
        val values by lazy {
            listOf(
                Headline.Large,
                Headline.Medium,
                Headline.Small,
                Title.Large,
                Title.Medium,
                Title.Small,
                Body.Large,
                Body.Medium,
                Body.Small,
                Label.Large,
                Label.Medium,
                Label.Small,
                Label.Detail
            )
        }
    }
}