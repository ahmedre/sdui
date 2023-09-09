package dev.helw.playground.sdui.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.helw.playground.sdui.action.Action
import dev.helw.playground.sdui.design.component.ProgressStatus
import dev.helw.playground.sdui.design.core.SizeToken
import dev.helw.playground.sdui.model.Component
import dev.helw.playground.sdui.serializer.SizeTokenSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("progressStatus")
class ProgressStatusComponent(
    private val amount: Int,
    private val total: Int,
    @Serializable(with = SizeTokenSerializer::class)
    private val size: SizeToken,
    override val identifier: String,
    override val actions: List<Action> = emptyList()
): Component {

    @Composable
    override fun Content(modifier: Modifier) {
        ProgressStatus(amount, total, size, modifier)
    }
}