package dev.helw.playground.sdui.component.list

import dev.helw.playground.sdui.design.core.SizeToken
import dev.helw.playground.sdui.design.core.TypographyToken
import dev.helw.playground.sdui.serializer.SizeTokenSerializer
import dev.helw.playground.sdui.serializer.TypographyTokenSerializer
import dev.helw.playground.sdui.serializer.model.BackgroundColorToken
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
sealed class ListItemLeading {
    abstract fun renderer(): ListItemLeadingRenderer

    @SerialName("letterCircle")
    @Serializable
    data class LetterCircle(
        val text: String,
        @Serializable(with = SizeTokenSerializer::class)
        private val size: SizeToken,
        @Serializable(with = TypographyTokenSerializer::class)
        private val typography: TypographyToken,
        private val backgroundColor: BackgroundColorToken
    ) : ListItemLeading() {
        override fun renderer(): ListItemLeadingRenderer {
            return provideListItemRendererProvider().provideListItemLeadingRendererProvider()
                .provideListItemLetterCircleRenderer(
                    text,
                    size,
                    typography,
                    backgroundColor
                )
        }
    }

    @SerialName("networkImage")
    @Serializable
    data class NetworkImage(
        val url: String,
        val contentDescription: String
    ) : ListItemLeading() {
        override fun renderer(): ListItemLeadingRenderer {
            return provideListItemRendererProvider().provideListItemLeadingRendererProvider()
                .provideListItemNetworkImageRenderer(url, contentDescription)
        }
    }
}