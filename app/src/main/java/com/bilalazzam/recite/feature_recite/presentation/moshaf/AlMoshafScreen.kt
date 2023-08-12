package com.bilalazzam.recite.feature_recite.presentation.moshaf


import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.bilalazzam.recite.R
import com.bilalazzam.recite.feature_recite.domain.model.Page

private const val TAG = "AlMoshafScreen"

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AlMoshafScreen(
    modifier: Modifier = Modifier,
    pageNumber: Int?,
    viewModel: AlMoshafViewModel = hiltViewModel()
) {
    val pages = viewModel.quranPages()
    val state = rememberPagerState(viewModel.currentPage.value as Int - 1)
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
                val bookmarked = index+1 == viewModel.bookmarkedPage.value
                Box {
                    Image(
                        painter = painterResource(id = pages[index].pageImage),
                        contentDescription = null,
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(8.dp)
                    )
                    Icon(
                        imageVector = ImageVector.vectorResource(id = if (bookmarked) R.drawable.bookmark_solid else R.drawable.bookmark_regular),
                        contentDescription = stringResource(R.string.bookmark),
                        modifier = Modifier
                            .padding(start = 42.dp, top = 8.dp)
                            .align(Alignment.TopStart)
                            .clickable {
                                viewModel.setBookmarkedPage(index + 1)
                            },
                        tint = Color.Red.copy(alpha = .3f),
                    )
                }
            }
        }
    }
    viewModel.setCurrentPage(state.currentPage + 1)
}