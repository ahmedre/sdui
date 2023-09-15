package dev.helw.playground.sdui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
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
    val url = remember { mutableStateOf("http://localhost:8000/response.json") }
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
        CustomUrlBox(url.value) {
            url.value = it
            refreshToggle.value = !refreshToggle.value
        }

        val resultMessage = when (parsingResult.value) {
            ParsingResult.ERROR -> "Error parsing JSON: ${error.value?.message}"
            ParsingResult.SUCCESS -> "Parsing successful"
        }

        Label(
            text = resultMessage,
            textColor = LocalTextColors.current.secondary,
            typographyToken = TypographyToken.Label.Large
        )
        serverDrivenUiResponse.value?.let { ServerDrivenUi(it, Modifier) }

        LaunchedEffect(refreshToggle.value) {
            runCatching {
                client
                    .get(url.value)
                    .body<ServerDrivenUiResponse>()
            }
                .onSuccess {
                    parsingResult.value = ParsingResult.SUCCESS
                    serverDrivenUiResponse.value = it
                }
                .onFailure {
                    parsingResult.value = ParsingResult.ERROR
                    serverDrivenUiResponse.value = null
                }
        }
    }
}

@Composable
private fun CustomUrlBox(url: String, onSet: (String) -> Unit) {
    var temporaryText by remember { mutableStateOf(url) }
    val focusRequester = remember { FocusRequester() }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        TextField(
            value = temporaryText,
            onValueChange = {
                temporaryText = it
            },
            placeholder = {
                Label(
                    text = "Paste your custom url here to fetch a custom response",
                    textColor = LocalTextColors.current.secondary,
                    typographyToken = TypographyToken.Label.Small
                )
            },
            modifier = Modifier.fillMaxWidth().focusRequester(focusRequester),
            maxLines = 5,
        )

        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            Button(
                onClick = { onSet(temporaryText) },
                modifier = Modifier.weight(1f),
            ) {
                Label(
                    text = "Parse",
                    textColor = LocalTextColors.current.primaryInverse,
                    typographyToken = TypographyToken.Label.Large
                )
            }
            Button(
                onClick = {
                    temporaryText = "http://localhost:8000/response.json"
                    onSet(temporaryText)
                },
                modifier = Modifier.weight(1f),
            ) {
                Label(
                    text = "Reset",
                    textColor = LocalTextColors.current.primaryInverse,
                    typographyToken = TypographyToken.Label.Large
                )
            }
        }
    }

    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }
}

private enum class ParsingResult { SUCCESS, ERROR }