package dev.helw.playground.sdui.design.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
expect fun AsyncImage(url: String, contentDescription: String, modifier: Modifier)