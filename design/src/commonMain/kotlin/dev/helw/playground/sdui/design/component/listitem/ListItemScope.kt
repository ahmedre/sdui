package dev.helw.playground.sdui.design.component.listitem

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import dev.helw.playground.sdui.design.component.AsyncImage
import dev.helw.playground.sdui.design.component.Icon
import dev.helw.playground.sdui.design.component.Label
import dev.helw.playground.sdui.design.core.BackgroundColor
import dev.helw.playground.sdui.design.core.IconToken
import dev.helw.playground.sdui.design.core.SizeToken
import dev.helw.playground.sdui.design.core.TypographyToken
import dev.helw.playground.sdui.design.core.color.LocalTextColors

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
                Label(
                    text = text,
                    typographyToken = typography,
                    textColor = LocalTextColors.current.primary
                )
            }
        }

        @Composable
        fun NetworkImage(
            url: String,
            contentDescription: String,
            sizeToken: SizeToken = SizeToken.MEDIUM
        ) = AsyncImage(url, contentDescription, sizeToken, Modifier.size(sizeToken.underlyingSize))

        @Composable
        fun StatusIcon(iconToken: IconToken, sizeToken: SizeToken = SizeToken.MEDIUM) =
            Icon(iconToken, sizeToken)
    }

    interface Content : ListItemScope {
        data object Title : Content {
            @Composable
            fun Title(text: String) {
                Label(
                    text = text,
                    typographyToken = TypographyToken.Title.Medium,
                    textColor = LocalTextColors.current.primary
                )
            }
        }

        data object Description : Content {
            @Composable
            fun Description(text: String) {
                Label(
                    text = text,
                    typographyToken = TypographyToken.Label.Medium,
                    textColor = LocalTextColors.current.secondary
                )
            }
        }
    }

    data object Trailing : ListItemScope {
        @Composable
        fun Detail(text: String) {
            Label(
                text = text,
                typographyToken = TypographyToken.Label.Large,
                textColor = LocalTextColors.current.tertiary
            )
        }

        @Composable
        fun StatusIcon(iconToken: IconToken, sizeToken: SizeToken = SizeToken.MEDIUM) =
            Icon(iconToken, sizeToken)
    }
}