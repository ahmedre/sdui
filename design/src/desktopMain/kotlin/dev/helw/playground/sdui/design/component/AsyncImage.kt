package dev.helw.playground.sdui.design.component

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.toPainter
import java.net.URL
import javax.imageio.ImageIO

@Composable
actual fun AsyncImage(url: String, contentDescription: String) {
    Image(
        painter = loadImage(url),
        contentDescription = contentDescription
    )
}

private fun loadImage(url: String): Painter = ImageIO.read(URL(url)).toPainter()