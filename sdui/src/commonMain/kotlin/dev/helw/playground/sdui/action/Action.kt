package dev.helw.playground.sdui.action

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
sealed class Action {
    @Serializable
    sealed class OnClick : Action() {
        @Serializable
        @SerialName("deeplink")
        class Deeplink(val deeplink: String) : OnClick()
    }

    @Serializable
    sealed class OnViewed : Action() {
        @Serializable
        @SerialName("impressionEvent")
        class ImpressionEvent(
            @SerialName("event_name") val eventName: String,
            val data: Map<String, String>
        ) : OnViewed()
    }
}