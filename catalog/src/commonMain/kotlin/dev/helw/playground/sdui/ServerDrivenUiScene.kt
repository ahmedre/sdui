package dev.helw.playground.sdui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Switch
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
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
import dev.helw.playground.sdui.parser.Parser

@Composable
internal fun ServerDrivenUiScene(modifier: Modifier = Modifier) {
    val isUsingCustomJson = remember { mutableStateOf(false) }
    val sduiJson = remember { mutableStateOf(json) }
    val serverDrivenUiResponse = remember { mutableStateOf<ServerDrivenUiResponse?>(null) }
    val parsingResult = remember { mutableStateOf(ParsingResult.SUCCESS) }
    val error = remember { mutableStateOf<Exception?>(null) }

    Column(modifier) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth().padding(16.dp)
        ) {
            Label(
                text = "Use custom JSON",
                textColor = LocalTextColors.current.secondary,
                typographyToken = TypographyToken.Label.Large
            )
            Switch(
                checked = isUsingCustomJson.value,
                onCheckedChange = { isUsingCustomJson.value = it })
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
        if (isUsingCustomJson.value) {
            CustomJsonField(sduiJson, parsingResult.value)
        }
        serverDrivenUiResponse.value?.let { ServerDrivenUi(it, Modifier) }

        LaunchedEffect(sduiJson.value) {
            if (sduiJson.value.isNotEmpty()) {
                try {
                    serverDrivenUiResponse.value = Parser.parse(sduiJson.value)
                    parsingResult.value = ParsingResult.SUCCESS
                } catch (e: Exception) {
                    error.value = e
                    parsingResult.value = ParsingResult.ERROR
                }
            }
        }

        LaunchedEffect(isUsingCustomJson.value) {
            if (!isUsingCustomJson.value) {
                sduiJson.value = json
            }
        }
    }
}

@Composable
private fun CustomJsonField(jsonText: MutableState<String>, parsingResult: ParsingResult) {
    var temporaryText by remember { mutableStateOf(jsonText.value) }
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
                    text = "Paste your custom JSON here and press Parse when ready",
                    textColor = LocalTextColors.current.secondary,
                    typographyToken = TypographyToken.Label.Small
                )
            },
            modifier = Modifier.fillMaxWidth().focusRequester(focusRequester),
            maxLines = 5,
        )

        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            Button(
                onClick = { jsonText.value = temporaryText },
                modifier = Modifier.weight(1f),
            ) {
                Label(
                    text = "Parse",
                    textColor = LocalTextColors.current.primaryInverse,
                    typographyToken = TypographyToken.Label.Large
                )
            }
            Button(
                onClick = { temporaryText = "" },
                modifier = Modifier.weight(1f),
            ) {
                Label(
                    text = "Clear",
                    textColor = LocalTextColors.current.primaryInverse,
                    typographyToken = TypographyToken.Label.Large
                )
            }
        }

        val resultMessage = when (parsingResult) {
            ParsingResult.ERROR -> "Error parsing JSON, check Logcat"
            ParsingResult.SUCCESS -> "Parsing succesful"
        }

        Label(
            text = resultMessage,
            textColor = LocalTextColors.current.secondary,
            typographyToken = TypographyToken.Label.Large
        )
    }

    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }
}

private enum class ParsingResult { SUCCESS, ERROR }