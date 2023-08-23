package dev.helw.playground.sdui.component.list

import androidx.compose.runtime.Composable
import dev.helw.playground.sdui.design.component.listitem.ListItemScope
import dev.helw.playground.sdui.design.core.SizeToken
import dev.helw.playground.sdui.design.core.TypographyToken
import dev.helw.playground.sdui.model.BackgroundColorToken
import dev.helw.playground.sdui.serializer.SizeTokenSerializer
import dev.helw.playground.sdui.serializer.TypographyTokenSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
sealed class ListItemLeading {
    abstract fun asListItemScope(): @Composable ListItemScope.Leading.() -> Unit

    @SerialName("letterCircle")
    @Serializable
    data class LetterCircle(
        val text: String,
        @Serializable(with = SizeTokenSerializer::class)
        private val size: SizeToken,
        @Serializable(with = TypographyTokenSerializer::class)
        private val typography: TypographyToken,
        private val backgroundColorToken: BackgroundColorToken
    ) : ListItemLeading() {

        override fun asListItemScope(): @Composable ListItemScope.Leading.() -> Unit =
            { LetterCircle(text, size, typography, backgroundColorToken.colorValue()) }
    }

    @SerialName("networkImage")
    @Serializable
    data class NetworkImage(
        val url: String,
        val contentDescription: String
    ) : ListItemLeading() {

        override fun asListItemScope(): @Composable ListItemScope.Leading.() -> Unit =
            { NetworkImage(url, contentDescription) }
    }
}