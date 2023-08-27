package dev.helw.playground.sdui.model.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.helw.playground.sdui.design.component.AsyncImage
import dev.helw.playground.sdui.model.Renderer

class AsyncImageRenderer(
    private val url: String,
    private val contentDescription: String
) : Renderer {

    @Composable
    override fun Content(modifier: Modifier) {
        AsyncImage(url, contentDescription)
    }
}