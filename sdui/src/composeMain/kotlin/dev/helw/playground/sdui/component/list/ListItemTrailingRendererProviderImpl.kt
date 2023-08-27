package dev.helw.playground.sdui.component.list

import androidx.compose.runtime.Composable
import dev.helw.playground.sdui.design.component.listitem.ListItemScope
import dev.helw.playground.sdui.design.core.IconToken
import dev.helw.playground.sdui.design.core.SizeToken

class ListItemTrailingRendererProviderImpl : ListItemTrailingRendererProvider {
    override fun provideListItemTrailingDetailRenderer(text: String): ListItemTrailingRenderer {
        return ListItemTrailingDetailRendererImpl(text)
    }

    override fun provideListItemTrailingStatusIconRenderer(
        icon: IconToken,
        size: SizeToken
    ): ListItemTrailingRenderer {
        return ListItemTrailingStatusIconRendererImpl(icon, size)
    }
}

class ListItemTrailingDetailRendererImpl(private val text: String) : ListItemTrailingRenderer {
    override fun render(): @Composable ListItemScope.Trailing.() -> Unit = {
        Detail(text)
    }
}

class ListItemTrailingStatusIconRendererImpl(
    private val icon: IconToken,
    private val size: SizeToken
) : ListItemTrailingRenderer {
    override fun render(
    ): @Composable ListItemScope.Trailing.() -> Unit = {
        StatusIcon(icon, size)
    }
}