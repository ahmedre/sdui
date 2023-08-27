package dev.helw.playground.sdui.model.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.helw.playground.sdui.design.component.Label
import dev.helw.playground.sdui.design.core.TypographyToken
import dev.helw.playground.sdui.model.Renderer
import dev.helw.playground.sdui.serializer.model.TextColorToken

class LabelRenderer(
    private val text: String,
    private val typography: TypographyToken,
    private val color: TextColorToken
) : Renderer {

    @Composable
    override fun Content(modifier: Modifier) {
        Label(
            text = text,
            typographyToken = typography,
            textColor = color.colorValue()
        )
    }
}