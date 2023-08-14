package com.bilalazzam.recite.feature_recite.presentation.moshafContent.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import com.bilalazzam.recite.feature_recite.presentation.moshafContent.MoshafContentState
import com.bilalazzam.recite.feature_recite.presentation.moshafContent.jozzaIndex.JozzaIndexScreen
import com.bilalazzam.recite.feature_recite.presentation.moshafContent.pageIndex.PageIndexScreen
import com.bilalazzam.recite.feature_recite.presentation.moshafContent.sorahIndex.SorahIndexScreen
import com.bilalazzam.recite.feature_recite.presentation.util.TabItem

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TabLayoutContent(
    tabs: List<TabItem>,
    state: PagerState,
    onItemClick: (Int) -> Unit,
    moshafContentState: MoshafContentState
) {
    HorizontalPager(
        pageCount = tabs.size,
        state = state,
        key = {tabs[it].title}
    ) {page ->
        when (tabs[page]) {
            is TabItem.SorahIndex -> SorahIndexScreen(sorahList = moshafContentState.sorahList, onSorahClick = onItemClick)
            is TabItem.JozzaIndex -> JozzaIndexScreen(jozzaList = moshafContentState.jozzaList, onJozzaClick = onItemClick)
            is TabItem.PageIndex -> PageIndexScreen(onPageClick = onItemClick)
        }
    }

}