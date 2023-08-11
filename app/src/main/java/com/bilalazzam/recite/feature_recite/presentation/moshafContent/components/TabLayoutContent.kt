package com.bilalazzam.recite.feature_recite.presentation.moshafContent.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import com.bilalazzam.recite.feature_recite.presentation.util.TabItem

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TabLayoutContent(
    tabs: List<TabItem>,
    state: PagerState
) {
    HorizontalPager(
        pageCount = tabs.size,
        state = state,
        key = {tabs[it].title}
    ) {page ->
        tabs[page].screen()
    }

}