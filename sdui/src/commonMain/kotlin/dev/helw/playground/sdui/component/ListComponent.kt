package dev.helw.playground.sdui.component

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.helw.playground.sdui.model.Component
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("list")
class ListComponent(
    private val contents: List<Component>,
    override val type: String,
    override val identifier: String
) : Component {

    @Composable
    override fun Content(modifier: Modifier) {
        LazyColumn {
            contents.forEach {
                item(key = it.identifier) {
                    it.Content(modifier)
                }
            }
        }
    }
}