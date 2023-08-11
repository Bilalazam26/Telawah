package com.bilalazzam.recite.feature_recite.presentation.main


import android.content.Context
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.bilalazzam.recite.feature_recite.domain.model.Jozza
import com.bilalazzam.recite.feature_recite.domain.model.Page
import com.bilalazzam.recite.feature_recite.domain.model.Sorah
import com.bilalazzam.recite.feature_recite.presentation.main.components.BottomNavGraph
import com.bilalazzam.recite.feature_recite.presentation.main.components.ReciteBottomNavigationBar
import com.bilalazzam.recite.feature_recite.presentation.moshafContent.MoshafContentState
import com.bilalazzam.recite.feature_recite.presentation.util.BottomNavScreen

@Composable
fun MainScreen(
    bottomNavigationState: BottomNavigationState,
    moshafContentState: MoshafContentState,
    context: Context,
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
                navController = bottomNavigationState.navController,
                moshafContentState = moshafContentState,
                context = context
            )
        }
    }

}
