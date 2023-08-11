package com.bilalazzam.recite.feature_recite.presentation.moshaf


import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.bilalazzam.recite.feature_recite.domain.model.Page

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AlMoshafScreen(
    modifier: Modifier = Modifier,
    pages: List<Page>,
    pageNumber: Int?
) {
    val state = rememberPagerState()
    LaunchedEffect(key1 = true) {
        if (pageNumber as Int != -1) {
            state.animateScrollToPage(pageNumber-1)
        }
    }

    Surface(
        modifier = modifier
            .fillMaxSize(),
        color = Color.White
    ) {
        Box(modifier = Modifier.fillMaxSize()){
            HorizontalPager(
                pageCount = 604,
                state = state,
                key = {pages[it].pageNumber}
            ) {index ->
                Image(
                    painter = painterResource(id = pages[index].pageImage),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp)
                )
            }
        }
    }
}