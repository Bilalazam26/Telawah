package com.bilalazzam.recite.feature_recite.presentation.main.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.bilalazzam.recite.feature_recite.presentation.moshaf.AlMoshafScreen
import com.bilalazzam.recite.feature_recite.presentation.moshafContent.MoshafContentScreen
import com.bilalazzam.recite.feature_recite.presentation.moshafContent.searchByAyah.SearchScreen
import com.bilalazzam.recite.feature_recite.presentation.util.BottomNavScreen
import com.bilalazzam.recite.feature_recite.presentation.util.Screen

@Composable
fun BottomNavGraph(
    navController: NavHostController
) {
    val context = LocalContext.current
    NavHost(
        navController = navController,
        startDestination = "${BottomNavScreen.AlMoshafScreen(context).route}/{pageNumber}"
    ) {
        composable(
            route = BottomNavScreen.MoshafContentScreen(context).route
        ) {
            MoshafContentScreen(
                onItemClick = {pageNumber ->
                    navController.navigate(
                        route = "${BottomNavScreen.AlMoshafScreen(context).route}/${pageNumber}"
                    ) {
                        popUpTo(navController.graph.findStartDestination().id)
                        launchSingleTop = true
                    }
                },
                onSearchClick = {
                    navController.navigate(
                        route = Screen.SearchScreen.route
                    )
                }
            )
        }
        composable(
            route = "${BottomNavScreen.AlMoshafScreen(context).route}/{pageNumber}",
            arguments = listOf(
                navArgument(
                    name = "pageNumber"
                ) {
                    type = NavType.IntType
                    defaultValue = -1
                }
            )
        ) {
            AlMoshafScreen(
                pageNumber = it.arguments?.getInt("pageNumber")
            )
        }

        composable(
            route = Screen.SearchScreen.route
        ) {
            SearchScreen(
                onAyahClick = {pageNumber ->
                    navController.navigate(
                        route = "${BottomNavScreen.AlMoshafScreen(context).route}/${pageNumber}"
                    )
                },
                navController = navController
            )
        }
    }

}
