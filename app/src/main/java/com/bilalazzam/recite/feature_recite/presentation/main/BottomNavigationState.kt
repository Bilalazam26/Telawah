package com.bilalazzam.recite.feature_recite.presentation.main

import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import com.bilalazzam.recite.feature_recite.presentation.util.BottomNavScreen

data class BottomNavigationState (
    var navController: NavHostController,
    var currentDestination: NavDestination?,
    var screens: List<BottomNavScreen>
)