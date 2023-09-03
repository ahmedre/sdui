package dev.helw.playground.sdui.component.core

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.helw.playground.sdui.action.Action
import dev.helw.playground.sdui.model.Component
import dev.helw.playground.sdui.model.SduiModifier
import dev.helw.playground.sdui.model.applyModifiers
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("column")
class ColumnComponent(
    private val contents: List<Component>,
    private val modifiers: List<SduiModifier> = emptyList(),
    override val identifier: String,
    override val actions: List<Action> = emptyList()
) : Component {

    @Composable
    override fun Content(modifier: Modifier) {
        Column(modifier.applyModifiers(modifiers)) {
            contents.forEach { it.Content(Modifier) }
        }
    }
}