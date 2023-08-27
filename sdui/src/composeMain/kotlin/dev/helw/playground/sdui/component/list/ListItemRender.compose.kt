package dev.helw.playground.sdui.component.list

import androidx.compose.runtime.Composable
import dev.helw.playground.sdui.design.component.listitem.ListItemScope

actual interface ListItemContentTitleRenderer {
    fun render(): @Composable ListItemScope.Content.Title.() -> Unit
}

actual interface ListItemContentDescriptionRenderer {
    fun render(): @Composable ListItemScope.Content.Description.() -> Unit
}

actual interface ListItemLeadingRenderer {
    fun render(): @Composable ListItemScope.Leading.() -> Unit
}

actual interface ListItemTrailingRenderer {
    fun render(): @Composable ListItemScope.Trailing.() -> Unit
}