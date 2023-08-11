package com.bilalazzam.recite.feature_recite.presentation.main.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import com.bilalazzam.recite.feature_recite.presentation.main.BottomNavigationState
import com.bilalazzam.recite.feature_recite.presentation.util.BottomNavScreen

@Composable
fun ReciteBottomNavigationBar(
    screens: List<BottomNavScreen>,
    currentDestination: NavDestination?,
    modifier: Modifier = Modifier,
    onItemClick: (BottomNavScreen) -> Unit
) {
    NavigationBar (
        containerColor = MaterialTheme.colorScheme.primary
    ) {
        screens.forEach {screen ->
            AddBottomNavigationItem(
                screen = screen,
                currentDestination = currentDestination,
                onItemClick = onItemClick,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}