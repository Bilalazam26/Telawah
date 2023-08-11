package com.bilalazzam.recite.feature_recite.presentation.main.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import com.bilalazzam.recite.feature_recite.presentation.util.BottomNavScreen


@Composable
fun RowScope.AddBottomNavigationItem(
    screen: BottomNavScreen,
    currentDestination: NavDestination?,
    onItemClick: (BottomNavScreen) -> Unit,
    modifier: Modifier = Modifier
) {
    val selected = currentDestination?.route == if (screen.route == "al_moshaf") "${screen.route}/{pageNumber}" else screen.route
    val contentColor = MaterialTheme.colorScheme.secondaryContainer
    NavigationBarItem(
        modifier = modifier,
        icon = {
            Column(
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    painter = painterResource(id = screen.icon),
                    contentDescription = null,
                    tint = contentColor,
                    modifier = Modifier.size(24.dp)
                )
                if (selected) {
                    Text(
                        text = screen.title,
                        style = MaterialTheme.typography.titleSmall,
                        color = contentColor
                    )
                }
            }
        },
        selected = selected,
        onClick = {onItemClick(screen)},
        colors = NavigationBarItemDefaults.colors(
            indicatorColor = MaterialTheme.colorScheme.primary
        )
    )
}