package dev.helw.playground.sdui.design.core

import androidx.compose.ui.text.TextStyle


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
        data object Large : Body("Body.Large", TextStyle())
        data object Medium : Body("Body.Medium", TextStyle())
        data object Small : Body("Body.Small", TextStyle())
    }

    sealed class Label(name: String, textStyle: TextStyle) : TypographyToken(name, textStyle) {
        data object Large : Label("Label.Large", TextStyle())
        data object Medium : Label("Label.Medium", TextStyle())
        data object Small : Label("Label.Small", TextStyle())
    }
}