package dev.helw.playground.sdui.design.core

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

enum class IconToken(val image: ImageVector) {
    HOME(Icons.Default.Home),
    FAVORITE(Icons.Default.Favorite),
    SETTINGS(Icons.Default.Settings)
}