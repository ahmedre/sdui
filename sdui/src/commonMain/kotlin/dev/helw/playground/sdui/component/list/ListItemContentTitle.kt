package dev.helw.playground.sdui.component.list

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
sealed class ListItemContentTitle {
    abstract fun renderer(): ListItemContentTitleRenderer

    @Serializable
    @SerialName("title")
    data class TitleContentTitle(val text: String) : ListItemContentTitle() {
        override fun renderer(): ListItemContentTitleRenderer {
            return provideListItemRendererProvider().provideListItemContentTitleRenderer(text)
        }
    }
}