package dev.helw.playground.sdui.model.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.helw.playground.sdui.design.component.Icon
import dev.helw.playground.sdui.design.core.IconToken
import dev.helw.playground.sdui.design.core.SizeToken
import dev.helw.playground.sdui.model.Renderer

class IconRenderer(
    private val icon: IconToken,
    private val size: SizeToken
) : Renderer {

    @Composable
    override fun Content(modifier: Modifier) {
        Icon(icon, size)
    }
}