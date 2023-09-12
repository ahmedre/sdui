package dev.helw.playground.sdui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.helw.playground.sdui.design.component.Label
import dev.helw.playground.sdui.design.core.TypographyToken
import dev.helw.playground.sdui.design.core.color.LocalTextColors
import dev.helw.playground.sdui.model.ServerDrivenUiResponse
import dev.helw.playground.sdui.network.sduiClient
import dev.helw.playground.sdui.parser.ServerDrivenUiSerializer
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json

@Composable
internal fun ServerDrivenUiScene(modifier: Modifier = Modifier) {
    val refreshToggle = remember { mutableStateOf(false) }
    val serverDrivenUiResponse = remember { mutableStateOf<ServerDrivenUiResponse?>(null) }
    val parsingResult = remember { mutableStateOf(ParsingResult.SUCCESS) }
    val error = remember { mutableStateOf<Exception?>(null) }
    val parser = ServerDrivenUiSerializer.default
    val client = remember {
        sduiClient {
            install(ContentNegotiation) {
                json(json = parser.json)
            }
            install(Logging) {
                logger = object : Logger {
                    override fun log(message: String) {
                        println("------------> KTOR: $message")
                    }
                }
                level = LogLevel.ALL
            }
        }
    }

    Column(modifier) {
        Button(
            onClick = { refreshToggle.value = !refreshToggle.value },
            modifier = Modifier.fillMaxWidth().padding(16.dp),
        ) {
            Label(
                text = "Refresh",
                textColor = LocalTextColors.current.primaryInverse,
                typographyToken = TypographyToken.Label.Large
            )
        }
        val resultMessage = when (parsingResult.value) {
            ParsingResult.ERROR -> "Error parsing JSON: ${error.value?.message}"
            ParsingResult.SUCCESS -> "Parsing succesful"
        }

        Label(
            text = resultMessage,
            textColor = LocalTextColors.current.secondary,
            typographyToken = TypographyToken.Label.Large
        )
        serverDrivenUiResponse.value?.let { ServerDrivenUi(it, Modifier) }


        LaunchedEffect(refreshToggle.value) {
            serverDrivenUiResponse.value = client
                .get("http://localhost:8000/response.json")
                .body<ServerDrivenUiResponse>()
        }
    }
}

private enum class ParsingResult { SUCCESS, ERROR }