package dev.helw.playground.sdui.model.component

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.helw.playground.sdui.model.Component
import dev.helw.playground.sdui.model.Renderer

class ListRenderer(
    private val contents: List<Component>
) : Renderer {

    @Composable
    override fun Content(modifier: Modifier) {
        LazyColumn(modifier = modifier) {
            contents.forEach {
                item(key = it.identifier) {
                    it.provideRenderer().Content(modifier)
                }
            }
        }
    }
}