/**
 * Copyright (c) 2024 Ahmed El-Helw and Abdulahi Osoble
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */
package dev.helw.playground.sdui.design.component.listitem

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.helw.playground.sdui.design.core.BackgroundColor

@Composable
fun ListItem(
    title: @Composable ListItemScope.Content.Title.() -> Unit,
    description: @Composable ListItemScope.Content.Description.() -> Unit = {},
    leading: @Composable ListItemScope.Leading.() -> Unit = {},
    trailing: @Composable ListItemScope.Trailing.() -> Unit = {},
    backgroundColor: BackgroundColor = BackgroundColor.Unspecified,
    modifier: Modifier = Modifier
) {
    androidx.compose.material3.ListItem(
        headlineContent = { ListItemScope.Content.Title.title() },
        supportingContent = { ListItemScope.Content.Description.description() },
        leadingContent = { ListItemScope.Leading.leading() },
        trailingContent = { ListItemScope.Trailing.trailing() },
        modifier = modifier.background(color = backgroundColor.color)
    )
}
