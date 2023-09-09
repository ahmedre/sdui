package dev.helw.playground.sdui

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.helw.playground.sdui.component.sandbox.ChallengeTrackerComponent
import dev.helw.playground.sdui.parser.ServerDrivenUiSerializer
import kotlinx.serialization.modules.subclass

@Composable
internal fun SandboxScene(modifier: Modifier = Modifier) {
    val parser = ServerDrivenUiSerializer.Builder()
        .addComponentSubclasses {
            subclass(ChallengeTrackerComponent::class)
        }
        .build()

    val response = parser.parse("""
        {
            "version": 1,
            "root": {
                "type": "challengeTracker",
                "amount": 3,
                "total": 10,
                "size": "medium",
                "identifier": "challengeTracker"
            }
        }
    """.trimIndent())

    Box(modifier) {
        ServerDrivenUi(response, Modifier)
    }
}