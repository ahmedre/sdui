package dev.helw.playground.sdui.component.list

import androidx.compose.runtime.Composable
import dev.helw.playground.sdui.design.component.listitem.ListItemScope

class ListItemContentTitleRendererImpl(private val text: String) : ListItemContentTitleRenderer {
    override fun render(): @Composable ListItemScope.Content.Title.() -> Unit = { Title(text) }
}