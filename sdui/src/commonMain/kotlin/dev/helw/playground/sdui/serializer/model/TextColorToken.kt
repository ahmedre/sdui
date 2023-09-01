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