package dev.helw.playground.sdui.component.list

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
sealed class ListItemContentDescription {
    abstract fun renderer(): ListItemContentDescriptionRenderer

    @Serializable
    @SerialName("description")
    data class DescriptionContentTitle(val text: String) : ListItemContentDescription() {
        override fun renderer(): ListItemContentDescriptionRenderer {
            return provideListItemRendererProvider().provideListItemContentDescriptionRenderer(text)
        }
    }
}