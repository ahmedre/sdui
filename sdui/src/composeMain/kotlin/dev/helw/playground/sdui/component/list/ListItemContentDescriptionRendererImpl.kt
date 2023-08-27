package dev.helw.playground.sdui.component.list

import androidx.compose.runtime.Composable
import dev.helw.playground.sdui.design.component.listitem.ListItemScope

class ListItemContentDescriptionRendererImpl(
    private val text: String
) : ListItemContentDescriptionRenderer {

    override fun render(): @Composable ListItemScope.Content.Description.() -> Unit =
        { Description(text) }
}