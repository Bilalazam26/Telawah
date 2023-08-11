package com.bilalazzam.recite.feature_recite.presentation.main.components

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.bilalazzam.recite.feature_recite.domain.model.Page
import com.bilalazzam.recite.feature_recite.presentation.moshaf.AlMoshafScreen
import com.bilalazzam.recite.feature_recite.presentation.moshafContent.MoshafContentScreen
import com.bilalazzam.recite.feature_recite.presentation.moshafContent.MoshafContentState
import com.bilalazzam.recite.feature_recite.presentation.moshafContent.components.searchByAyah.SearchScreen
import com.bilalazzam.recite.feature_recite.presentation.util.BottomNavScreen
import com.bilalazzam.recite.feature_recite.presentation.util.Screen

@Composable
fun BottomNavGraph(
    navController: NavHostController,
    pages: List<Page>,
    moshafContentState: MoshafContentState,
    context: Context
) {
    NavHost(
        navController = navController,
        startDestination = "${BottomNavScreen.AlMoshafScreen(context).route}/{pageNumber}"
    ) {
        composable(
            route = BottomNavScreen.MoshafContentScreen(context).route
        ) {
            MoshafContentScreen(
                moshafContentState = moshafContentState,
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
                },
                context = context
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
                pages = pages,
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
                }
            )
        }
    }

}
