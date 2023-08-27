package dev.helw.playground.sdui.component.list

import dev.helw.playground.sdui.design.core.IconToken
import dev.helw.playground.sdui.design.core.SizeToken
import dev.helw.playground.sdui.serializer.IconTokenSerializer
import dev.helw.playground.sdui.serializer.SizeTokenSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
sealed class ListItemTrailing {
    abstract fun renderer(): ListItemTrailingRenderer

    @SerialName("detail")
    @Serializable
    data class DetailTrailing(
        val text: String
    ) : ListItemTrailing() {
        override fun renderer(): ListItemTrailingRenderer =
            provideListItemRendererProvider().provideListItemTrailingRendererProvider()
                .provideListItemTrailingDetailRenderer(text)
    }

    @SerialName("statusIcon")
    @Serializable
    data class StatusIconTrailing(
        @Serializable(with = IconTokenSerializer::class)
        private val icon: IconToken,
        @Serializable(with = SizeTokenSerializer::class)
        private val size: SizeToken,
    ) : ListItemTrailing() {

        override fun renderer(): ListItemTrailingRenderer =
            provideListItemRendererProvider().provideListItemTrailingRendererProvider()
                .provideListItemTrailingStatusIconRenderer(icon, size)
    }
}