package dev.helw.playground.sdui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.helw.playground.sdui.design.component.listitem.ListItem
import dev.helw.playground.sdui.design.core.IconToken
import dev.helw.playground.sdui.design.core.color.LocalBackgroundColors

@Composable
fun NativeListScene(modifier: Modifier = Modifier) {
    val state = rememberLazyListState()
    LazyColumn(
        state = state,
        modifier = modifier
    ) {
        items(50) {
            ListItem(
                title = { Title("Title $it") },
                description = { Description("Description $it") },
                leading = {
                    if (it % 2 == 0) {
                        LetterCircle(
                            text = "$it",
                            backgroundColor = LocalBackgroundColors.current.primary
                        )
                    } else {
                        NetworkImage(
                            url = "https://images.freeimages.com/images/large-previews/8d1/summer-joy-1629829.jpg",
                            contentDescription = "Random Network Image $it"
                        )
                    }
                },
                trailing = {
                    if (it % 2 == 0) {
                        Detail(text = "$it")
                    } else {
                        StatusIcon(iconToken = IconToken.ARROW_FORWARD)
                    }
                },
                onClick = { }
            )
        }
    }
}