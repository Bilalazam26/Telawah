package com.bilalazzam.recite.feature_recite.presentation.main


import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.bilalazzam.recite.feature_recite.presentation.main.components.BottomNavGraph
import com.bilalazzam.recite.feature_recite.presentation.main.components.ReciteBottomNavigationBar

@Composable
fun MainScreen(
    bottomNavigationState: BottomNavigationState,
    modifier: Modifier = Modifier
) {
    Scaffold(
        bottomBar = {
            ReciteBottomNavigationBar(
                screens = bottomNavigationState.screens,
                currentDestination = bottomNavigationState.currentDestination,
                onItemClick = {screen ->
                    val route = if (screen.route == bottomNavigationState.screens[0].route) "${screen.route}/${-1}" else screen.route
                    bottomNavigationState.navController.navigate(route) {
                        popUpTo(bottomNavigationState.navController.graph.findStartDestination().id)
                        launchSingleTop = true
                    }
                }
            )
        }
    ) { paddingValues ->
        Surface(
            modifier = modifier.padding(paddingValues = paddingValues),
            color = Color.White
        ) {
            BottomNavGraph(
                navController = bottomNavigationState.navController
            )
        }
    }

}
