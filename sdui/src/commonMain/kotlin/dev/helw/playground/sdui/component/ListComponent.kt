package dev.helw.playground.sdui.component

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.helw.playground.sdui.action.Action
import dev.helw.playground.sdui.action.handleActions
import dev.helw.playground.sdui.model.Component
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("list")
class ListComponent(
    private val contents: List<Component>,
    override val identifier: String,
    override val actions: List<Action> = emptyList()
) : Component {

    @Composable
    override fun Content(modifier: Modifier) {
        LazyColumn(modifier = modifier.handleActions(actions)) {
            contents.forEach {
                item(key = it.identifier) {
                    it.Content(Modifier)
                }
            }
        }
    }
}