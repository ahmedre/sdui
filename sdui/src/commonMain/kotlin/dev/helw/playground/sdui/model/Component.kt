package dev.helw.playground.sdui.model

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.helw.playground.sdui.action.Action

interface Component {
    val identifier: String
    val actions: List<Action>

    @Composable fun Content(modifier: Modifier)
}