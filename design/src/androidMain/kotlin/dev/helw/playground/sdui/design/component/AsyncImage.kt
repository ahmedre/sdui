package dev.helw.playground.sdui.design.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import coil.request.ImageRequest

@Composable
actual fun AsyncImage(url: String, contentDescription: String, modifier: Modifier) {
    coil.compose.AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(url)
            .build(),
        contentDescription = contentDescription,
        modifier = modifier
    )
}