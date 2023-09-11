package dev.helw.playground.sdui.design.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.helw.playground.sdui.design.core.SizeToken

@Composable
expect fun AsyncImage(url: String, contentDescription: String, size: SizeToken, modifier: Modifier)