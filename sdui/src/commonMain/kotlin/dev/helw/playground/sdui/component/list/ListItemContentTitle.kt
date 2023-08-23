package dev.helw.playground.sdui.component.list

import androidx.compose.runtime.Composable
import dev.helw.playground.sdui.design.component.listitem.ListItemScope
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
sealed class ListItemContentTitle {
    abstract fun asListItemScope(): @Composable ListItemScope.Content.Title.() -> Unit

    @Serializable
    @SerialName("title")
    data class TitleContentTitle(val text: String) : ListItemContentTitle() {
        override fun asListItemScope(): @Composable ListItemScope.Content.Title.() -> Unit =
            { Title(text) }
    }
}