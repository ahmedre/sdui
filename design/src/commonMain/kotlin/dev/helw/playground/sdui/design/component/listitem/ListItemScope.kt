package dev.helw.playground.sdui.design.component.listitem

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import dev.helw.playground.sdui.design.component.AsyncImage
import dev.helw.playground.sdui.design.component.Icon
import dev.helw.playground.sdui.design.core.BackgroundColor
import dev.helw.playground.sdui.design.core.IconToken
import dev.helw.playground.sdui.design.core.SizeToken
import dev.helw.playground.sdui.design.core.TypographyToken

sealed interface ListItemScope {
    data object Leading : ListItemScope {

        @Composable
        fun LetterCircle(
            text: String,
            sizeToken: SizeToken = SizeToken.MEDIUM,
            typography: TypographyToken = TypographyToken.Label.Medium,
            backgroundColor: BackgroundColor = BackgroundColor.Unspecified
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.size(sizeToken.underlyingSize)
                    .clip(CircleShape)
                    .background(backgroundColor.color)
            ) {
                Text(
                    text = text,
                    style = typography.textStyle
                )
            }
        }

        @Composable
        fun NetworkImage(
            url: String,
            contentDescription: String,
            sizeToken: SizeToken = SizeToken.MEDIUM
        ) = AsyncImage(url, contentDescription, Modifier.size(sizeToken.underlyingSize))

        @Composable
        fun StatusIcon(iconToken: IconToken, sizeToken: SizeToken = SizeToken.MEDIUM) =
            Icon(iconToken, sizeToken)
    }

    interface Content : ListItemScope {
        data object Title : Content {
            @Composable
            fun Title(text: String) {
                Text(text = text, style = TypographyToken.Title.Medium.textStyle)
            }
        }

        data object Description : Content {
            @Composable
            fun Description(text: String) {
                Text(text = text, style = TypographyToken.Label.Medium.textStyle)
            }
        }
    }

    data object Trailing : ListItemScope {
        @Composable
        fun Detail(text: String) {
            Text(text = text, style = TypographyToken.Label.Detail.textStyle)
        }

        @Composable
        fun StatusIcon(iconToken: IconToken, sizeToken: SizeToken = SizeToken.MEDIUM) =
            Icon(iconToken, sizeToken)
    }
}