package dev.helw.playground.sdui.component.list

import androidx.compose.runtime.Composable
import dev.helw.playground.sdui.design.component.listitem.ListItemScope
import dev.helw.playground.sdui.design.core.SizeToken
import dev.helw.playground.sdui.design.core.TypographyToken
import dev.helw.playground.sdui.serializer.model.BackgroundColorToken

class ListItemLeadingRendererImpl : ListItemLeadingRendererProvider {
    override fun provideListItemLetterCircleRenderer(text: String,
                                                     size: SizeToken,
                                                     typography: TypographyToken,
                                                     backgroundColor: BackgroundColorToken): ListItemLeadingRenderer {
        return ListItemLeadingLetterCircleRendererImpl(text, size, typography, backgroundColor)
    }

    override fun provideListItemNetworkImageRenderer(url: String, contentDescription: String): ListItemLeadingRenderer {
        return ListItemLeadingNetworkImageRendererImpl(url, contentDescription)
    }
}

class ListItemLeadingLetterCircleRendererImpl(
    private val text: String,
    private val size: SizeToken,
    private val typography: TypographyToken,
    private val backgroundColor: BackgroundColorToken
) : ListItemLeadingRenderer {
    override fun render(): @Composable ListItemScope.Leading.() -> Unit = {
        LetterCircle(text, size, typography, backgroundColor.colorValue())
    }
}

class ListItemLeadingNetworkImageRendererImpl(
    private val url: String,
    private val contentDescription: String
) : ListItemLeadingRenderer {
    override fun render(): @Composable ListItemScope.Leading.() -> Unit = {
        NetworkImage(url, contentDescription)
    }
}