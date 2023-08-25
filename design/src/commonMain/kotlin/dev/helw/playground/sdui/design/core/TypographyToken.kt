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
        data object Large : Headline(
            name = "Headline.Large",
            textStyle = TextStyle(
                fontFamily = DefaultFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 32.sp,
                lineHeight = 40.0.sp,
                letterSpacing = 0.sp,
                platformStyle = DefaultPlatformTextStyle,
            )
        )

        data object Medium : Headline(
            name = "Headline.Medium",
            textStyle = TextStyle(
                fontFamily = DefaultFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 28.sp,
                lineHeight = 36.sp,
                letterSpacing = 0.sp,
                platformStyle = DefaultPlatformTextStyle,
            )
        )

        data object Small : Headline(
            name = "Headline.Small",
            textStyle = TextStyle(
                fontFamily = DefaultFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 24.sp,
                lineHeight = 32.sp,
                letterSpacing = 0.sp,
                platformStyle = DefaultPlatformTextStyle,
            )
        )
    }

    sealed class Title(name: String, textStyle: TextStyle) : TypographyToken(name, textStyle) {
        data object Large : Title(
            name = "Title.Large",
            textStyle = TextStyle(
                fontFamily = DefaultFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 22.sp,
                lineHeight = 28.sp,
                letterSpacing = 0.sp,
                platformStyle = DefaultPlatformTextStyle,
            )
        )

        data object Medium : Title(
            name = "Title.Medium",
            textStyle = TextStyle(
                fontFamily = DefaultFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                lineHeight = 24.sp,
                letterSpacing = .2.sp,
                platformStyle = DefaultPlatformTextStyle,
            )
        )

        data object Small : Title(
            name = "Title.Small",
            textStyle = TextStyle(
                fontFamily = DefaultFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                lineHeight = 20.sp,
                letterSpacing = .1.sp,
                platformStyle = DefaultPlatformTextStyle,
            )
        )
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
        data object Large : Label(
            name = "Label.Large",
            textStyle = TextStyle(
                fontFamily = DefaultFontFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp,
                lineHeight = 20.sp,
                letterSpacing = .1.sp,
                platformStyle = DefaultPlatformTextStyle,
            )
        )

        data object Medium : Label(
            name = "Label.Medium",
            textStyle = TextStyle(
                fontFamily = DefaultFontFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 12.sp,
                lineHeight = 16.sp,
                letterSpacing = .5.sp,
                platformStyle = DefaultPlatformTextStyle,
            )
        )

        data object Small : Label(
            name = "Label.Small",
            textStyle = TextStyle(
                fontFamily = DefaultFontFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 11.sp,
                lineHeight = 16.sp,
                letterSpacing = .5.sp,
                platformStyle = DefaultPlatformTextStyle,
            )
        )

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