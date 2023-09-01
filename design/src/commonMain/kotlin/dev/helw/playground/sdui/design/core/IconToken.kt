package dev.helw.playground.sdui.design.core

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

enum class IconToken(val image: ImageVector) {
    HOME(Icons.Default.Home),
    ADD(Icons.Default.Add),
    DELETE(Icons.Default.Delete),
    FAVORITE(Icons.Default.Favorite),
    SETTINGS(Icons.Default.Settings),
    LIST(Icons.Default.List),
    CHECK(Icons.Default.Check),
    ARROW_FORWARD(Icons.Default.ArrowForward),
    ARROW_BACK(Icons.Default.ArrowBack),
    PLACE(Icons.Default.Place),
    INFO(Icons.Default.Info),
}