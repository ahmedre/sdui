package dev.helw.playground.sdui.component.sandbox

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.helw.playground.sdui.action.Action
import dev.helw.playground.sdui.design.component.Label
import dev.helw.playground.sdui.design.component.ProgressStatus
import dev.helw.playground.sdui.design.core.SizeToken
import dev.helw.playground.sdui.design.core.TypographyToken
import dev.helw.playground.sdui.design.core.color.LocalTextColors
import dev.helw.playground.sdui.model.Component
import dev.helw.playground.sdui.serializer.SizeTokenSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("challengeTracker")
class ChallengeTrackerComponent(
    private val amount: Int,
    private val total: Int,
    @Serializable(with = SizeTokenSerializer::class)
    private val size: SizeToken,
    override val identifier: String,
    override val actions: List<Action> = emptyList()
) : Component {

    @Composable
    override fun Content(modifier: Modifier) {
        Row(
            modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Label(
                    "Challenge Tracker",
                    TypographyToken.Title.Small,
                    LocalTextColors.current.tertiary
                )
                Label(
                    "Place your first order",
                    TypographyToken.Headline.Small,
                    LocalTextColors.current.primary
                )
                Label(
                    "Order and earn a free delivery!",
                    TypographyToken.Title.Medium,
                    LocalTextColors.current.secondary
                )
            }
            ProgressStatus(amount, total, size, Modifier.weight(1f))
        }
    }
}