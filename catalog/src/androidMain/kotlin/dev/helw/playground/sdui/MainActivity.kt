package dev.helw.playground.sdui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.helw.playground.sdui.action.ActionHandler
import dev.helw.playground.sdui.action.LocalServerDrivenUiActionHandler
import dev.helw.playground.sdui.action.OnClick
import dev.helw.playground.sdui.action.OnViewed
import dev.helw.playground.sdui.design.theme.AppTheme

class MainActivity : ComponentActivity() {

    private val actionHandler = object : ActionHandler {
        override suspend fun onClick(action: OnClick) {
            when (action) {
                is OnClick.Deeplink -> {
                    val message = "Deeplink to ${action.deeplink}"
                    println("---------> ONCLICK: $message")
                    Toast.makeText(
                        this@MainActivity,
                        message,
                        Toast.LENGTH_SHORT
                    ).show()
                }

                is OnClick.InteractionEvent -> {
                    Toast.makeText(
                        this@MainActivity,
                        "Event name: ${action.eventName}, data: ${action.data}",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }

        override suspend fun onViewed(action: OnViewed) {
            when (action) {
                is OnViewed.ImpressionEvent -> {
                    Toast.makeText(
                        this@MainActivity,
                        "Event name: ${action.eventName}, data: ${action.data}",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CompositionLocalProvider(LocalServerDrivenUiActionHandler provides actionHandler) {
                AppTheme {
                    MainScaffold()
                }
            }
        }
    }
}

@Composable
private fun MainScaffold(startDestination: String = "home") {
    val navController = rememberNavController()

    Surface(modifier = Modifier.fillMaxSize()) {
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
