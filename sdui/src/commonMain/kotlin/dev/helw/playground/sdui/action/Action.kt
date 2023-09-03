package dev.helw.playground.sdui.action

import androidx.compose.foundation.clickable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import kotlinx.coroutines.launch
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

interface Action

@Serializable
sealed class OnClick : Action {
    @Serializable
    @SerialName("${SERIAL_NAME_PREFIX}_deeplink")
    class Deeplink(@SerialName("deeplink") val deeplink: String) : OnClick() {
        override fun toString(): String {
            return "Deeplink(deeplink='$deeplink')"
        }
    }

    @Serializable
    @SerialName("${SERIAL_NAME_PREFIX}_interactionEvent")
    class InteractionEvent(
        @SerialName("event_name") val eventName: String,
        val data: Map<String, String>
    ) : OnClick() {
        override fun toString(): String {
            return "InteractionEvent(eventName='$eventName', data=$data)"
        }
    }

    private companion object {
        const val SERIAL_NAME_PREFIX = "onClick"
    }
}

@Serializable
sealed class OnViewed : Action {
    abstract val impressionType: ImpressionType
    abstract val visibilityThreshold: Float

    @Serializable
    @SerialName("${SERIAL_NAME_PREFIX}_impressionEvent")
    class ImpressionEvent(
        @SerialName("impression_type") override val impressionType: ImpressionType,
        @SerialName("visibilityThreshold") override val visibilityThreshold: Float,
        @SerialName("event_name") val eventName: String,
        val data: Map<String, String>
    ) : OnViewed()

    enum class ImpressionType {
        ON_SCREEN, OFF_SCREEN
    }

    private companion object {
        const val SERIAL_NAME_PREFIX = "onViewed"
    }
}


internal fun Modifier.handleActions(actions: List<Action>): Modifier = composed {
    val handler = LocalServerDrivenUiActionHandler.current
    val scope = rememberCoroutineScope()
    var localModifier = this
    actions.forEach { action ->
        localModifier = when (action) {
            is OnClick -> localModifier.clickable {
                scope.launch { handler.onClick(action) }
            }

            // TODO Update with impression modifier
            is OnViewed -> TODO()

            else -> throw IllegalArgumentException("Invalid action: $action")
        }
    }
    localModifier
}