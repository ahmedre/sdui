package dev.helw.playground.sdui.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.helw.playground.sdui.design.component.AsyncImage
import dev.helw.playground.sdui.model.Component
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("asyncImage")
class AsyncImageComponent(
    private val url: String,
    private val contentDescription: String,
    override val identifier: String
) : Component {

    @Composable
    override fun Content(modifier: Modifier) {
        AsyncImage(url, contentDescription, modifier)
    }
}