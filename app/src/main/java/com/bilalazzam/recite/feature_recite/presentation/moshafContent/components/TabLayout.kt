package com.bilalazzam.recite.feature_recite.presentation.moshafContent.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.bilalazzam.recite.feature_recite.presentation.util.TabItem

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TabLayout(
    tabs: List<TabItem>
) {
    val state = rememberPagerState()
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Tabs(
            tabs = tabs,
            state = state
        )
        TabLayoutContent(
            tabs = tabs,
            state = state
        )
    }
}