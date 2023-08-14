package com.bilalazzam.recite.feature_recite.presentation.main

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.bilalazzam.recite.feature_recite.data.dataSource.local.SharedPreference
import com.bilalazzam.recite.feature_recite.presentation.moshafContent.MoshafContentViewModel
import com.bilalazzam.recite.feature_recite.presentation.splash.SplashScreen
import com.bilalazzam.recite.feature_recite.presentation.splash.SplashViewModel
import com.bilalazzam.recite.feature_recite.presentation.util.BottomNavScreen
import com.bilalazzam.recite.ui.theme.ReciteTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        SharedPreference.set(this.getPreferences(Context.MODE_PRIVATE))

        setContent {
            val splashViewModel = viewModel<SplashViewModel>()
            val moshafContentViewModel = viewModel<MoshafContentViewModel>()
            ReciteTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    if (splashViewModel.isLoading.value) {
                        SplashScreen()
                    } else {
                        //MainContent
                        //next step : try to use viewModel by moving states to viewModel
                        val navController = rememberNavController()
                        val navBackStackEntry by navController.currentBackStackEntryAsState()
                        var state = BottomNavigationState(
                            navController =navController,
                            currentDestination = navBackStackEntry?.destination,
                            screens = listOf(
                                BottomNavScreen.AlMoshafScreen(this),
                                BottomNavScreen.MoshafContentScreen(this)
                            )
                        )
                        MainScreen(
                            bottomNavigationState = state,
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                }
            }
        }
    }
}

