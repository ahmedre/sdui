/**
 * Copyright (c) 2023 Ahmed El-Helw and Abdulahi Osoble
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */
package dev.helw.playground.sdui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import dev.helw.playground.sdui.design.component.Icon
import dev.helw.playground.sdui.design.component.Label
import dev.helw.playground.sdui.design.core.IconToken
import dev.helw.playground.sdui.design.core.SizeToken
import dev.helw.playground.sdui.design.core.TypographyToken
import dev.helw.playground.sdui.design.core.color.LocalTextColors

@Composable
internal fun MainDemo(
    graph: List<Destination>,
    onClick: (Destination) -> Unit,
    modifier: Modifier = Modifier
) {
    val listState = rememberLazyListState()

    LazyColumn(
        state = listState,
        modifier = modifier
    ) {
        items(graph) { destination ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onClick(destination) }
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                Icon(
                    destination.icon,
                    SizeToken.SMALL,
                    contentDescription = destination.title
                )
                Column(modifier = Modifier.weight(1f).padding(horizontal = 16.dp)) {
                    Label(
                        text = destination.title,
                        typographyToken = TypographyToken.Body.Large,
                        textColor = LocalTextColors.current.primary,
                    )
                    Label(
                        text = destination.subtitle,
                        typographyToken = TypographyToken.Body.Small,
                        textColor = LocalTextColors.current.secondary,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 2,
                    )
                }
                Icon(
                    IconToken.ARROW_FORWARD,
                    SizeToken.SMALL,
                    contentDescription = destination.title
                )
            }
        }
    }
}
