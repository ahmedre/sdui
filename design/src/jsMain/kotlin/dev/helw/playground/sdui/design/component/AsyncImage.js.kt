package dev.helw.playground.sdui.design.component

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.toComposeImageBitmap
import io.ktor.client.HttpClient
import io.ktor.client.engine.js.JsClient
import io.ktor.client.request.get
import io.ktor.client.statement.readBytes
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.jetbrains.skia.Image

private val httpClient = HttpClient(JsClient())

@Composable
actual fun AsyncImage(url: String, contentDescription: String, modifier: Modifier) {
    val image: ImageBitmap? by produceState<ImageBitmap?>(null) {
        value = withContext(Dispatchers.Default) {
            val bytes = httpClient.get(url).readBytes()
            imageBitmapFromBytes(bytes)
        }
    }

    if (image != null) {
        Image(image!!,
            contentDescription,
            modifier = modifier
        )
    }
}

fun imageBitmapFromBytes(encodedImageData: ByteArray): ImageBitmap {
    return Image.makeFromEncoded(encodedImageData).toComposeImageBitmap()
}