package dev.helw.playground.sdui.component.list

import androidx.compose.runtime.Composable
import dev.helw.playground.sdui.design.component.listitem.ListItemScope
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
sealed class ListItemContentDescription {
    abstract fun asListItemScope(): @Composable ListItemScope.Content.Description.() -> Unit

    @Serializable
    @SerialName("description")
    data class DescriptionContentTitle(val text: String) : ListItemContentDescription() {
        override fun asListItemScope(): @Composable ListItemScope.Content.Description.() -> Unit =
            { Description(text) }
    }
}