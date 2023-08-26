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
    @SerialName("secondary") SECONDARY(BackgroundColors::secondary);

    @Composable
    @ReadOnlyComposable
    fun colorValue(): BackgroundColor {
        return LocalBackgroundColors.current.backgroundColor()
    }
}