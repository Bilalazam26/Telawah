package com.bilalazzam.recite.feature_recite.presentation.moshafContent.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.bilalazzam.recite.feature_recite.presentation.moshafContent.MoshafContentState
import com.bilalazzam.recite.feature_recite.presentation.moshafContent.MoshafContentViewModel
import com.bilalazzam.recite.feature_recite.presentation.util.TabItem

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TabLayout(
    tabs: List<TabItem>,
    onItemClick: (Int) -> Unit,
    viewModel: MoshafContentViewModel = hiltViewModel()
) {
    val moshafContentState = MoshafContentState(
        sorahList = viewModel.sorahListState.value,
        jozzaList = viewModel.jozzaListState.value
    )
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
            state = state,
            onItemClick = onItemClick,
            moshafContentState = moshafContentState
        )
    }
}