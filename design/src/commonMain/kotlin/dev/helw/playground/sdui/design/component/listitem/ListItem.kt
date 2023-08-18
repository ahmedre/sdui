package dev.helw.playground.sdui.design.component.listitem

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListItem(
    title: @Composable ListItemScope.Content.Title.() -> Unit,
    description: @Composable ListItemScope.Content.Description.() -> Unit = {},
    leading: @Composable ListItemScope.Leading.() -> Unit = {},
    trailing: @Composable ListItemScope.Trailing.() -> Unit = {},
    onClick: () -> Unit = {},
    backgroundColor: Color = Color.Unspecified
) {

    androidx.compose.material3.ListItem(
        headlineText = { ListItemScope.Content.Title.title() },
        supportingText = { ListItemScope.Content.Description.description() },
        leadingContent = { ListItemScope.Leading.leading() },
        trailingContent = { ListItemScope.Trailing.trailing() }
    )
}