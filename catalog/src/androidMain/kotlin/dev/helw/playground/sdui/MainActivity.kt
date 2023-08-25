package dev.helw.playground.sdui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.helw.playground.sdui.design.component.Icon
import dev.helw.playground.sdui.design.component.Label
import dev.helw.playground.sdui.design.core.IconToken
import dev.helw.playground.sdui.design.core.SizeToken
import dev.helw.playground.sdui.design.core.TypographyToken
import dev.helw.playground.sdui.design.core.color.LocalTextColors
import dev.helw.playground.sdui.design.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                MainScaffold()
            }
        }
    }
}

@Composable
private fun MainScaffold(startDestination: String = "home") {
    val navController = rememberNavController()

    //this configuration is passed for testing purpose only - in prod will be supplied by SA
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        CompositionLocalProvider(
            LocalOnBackClick provides { navController.popBackStack() }
        ) {
            NavHost(
                navController = navController,
                startDestination = startDestination,
                modifier = Modifier
                    .fillMaxSize()
            ) {
                composable(startDestination) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .systemBarsPadding()
                    ) {
                        MainDemo(
                            graph = NavigationGraph,
                            onClick = { navController.navigate(it.route) },
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(top = 64.dp),
                        )
                    }
                }
                NavigationGraph.forEach { destination ->
                    composable(route = destination.route) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .systemBarsPadding()
                        ) {
                            destination.content(
                                Modifier
                                    .fillMaxSize()
                                    .padding(top = 64.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun MainDemo(
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
