package com.bilalazzam.recite.feature_recite.presentation.util

import android.content.Context
import com.bilalazzam.recite.R

sealed class Screen (
    val route: String
) {
    object SearchScreen: Screen("search")
}

sealed class BottomNavScreen(
    route: String,
    val title: String,
    val icon: Int
): Screen(route = route) {

    class AlMoshafScreen(context: Context): BottomNavScreen(
        route = "al_moshaf",
        title = context.resources.getString(R.string.al_moshaf),
        icon = R.drawable.quran
    )
    class MoshafContentScreen(context: Context): BottomNavScreen(
        route = "moshaf_content",
        title = context.resources.getString(R.string.moshaf_content),
        icon = R.drawable.index
    )
}
