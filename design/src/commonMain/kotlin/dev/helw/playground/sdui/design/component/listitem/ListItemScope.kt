package dev.helw.playground.sdui.design.component.listitem

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
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
            Text(
                text = initials,
                style = typography.textStyle,
                modifier = Modifier.size(sizeToken.underlyingSize)
                    .drawBehind {
                        drawCircle(
                            color = backgroundColor.color,
                            radius = (sizeToken.underlyingSize / 2).value
                        )
                    }
            )
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