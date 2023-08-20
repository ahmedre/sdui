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
import dev.helw.playground.sdui.design.core.BackgroundColor
import dev.helw.playground.sdui.design.core.IconToken
import dev.helw.playground.sdui.design.core.SizeToken
import dev.helw.playground.sdui.design.core.TypographyToken

sealed interface ListItemScope {
    data object Leading : ListItemScope {
        @Composable
        fun Icon(iconToken: IconToken, sizeToken: SizeToken = SizeToken.MEDIUM) {
            androidx.compose.material3.Icon(
                imageVector = iconToken.image,
                contentDescription = "",
                modifier = Modifier.size(sizeToken.underlyingSize)
            )
        }

        @Composable
        fun LetterCircle(
            text: String,
            sizeToken: SizeToken = SizeToken.MEDIUM,
            typography: TypographyToken = TypographyToken.Label.Medium,
            backgroundColor: BackgroundColor = BackgroundColor.Unspecified
        ) {
            val pieces = text.split(" ")
            val initials = pieces.take(2)
                .mapNotNull { it.firstOrNull()?.uppercase() }
                .joinToString("")

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.size(sizeToken.underlyingSize)
                    .clip(CircleShape)
                    .background(backgroundColor.color)
            ) {
                Text(
                    text = initials,
                    style = typography.textStyle
                )
            }
        }
    }

    interface Content : ListItemScope {
        data object Title : Content {
        }

        data object Description : Content {
        }
    }

    data object Trailing : ListItemScope {
    }
}