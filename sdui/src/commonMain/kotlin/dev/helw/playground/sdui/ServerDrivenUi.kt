package dev.helw.playground.sdui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.helw.playground.sdui.model.ServerDrivenUiResponse

@Composable
expect fun ServerDrivenUi(serverDrivenUiResponse: ServerDrivenUiResponse, modifier: Modifier)