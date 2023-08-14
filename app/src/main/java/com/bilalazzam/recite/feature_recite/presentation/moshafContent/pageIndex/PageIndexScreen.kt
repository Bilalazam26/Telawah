package com.bilalazzam.recite.feature_recite.presentation.moshafContent.pageIndex

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.bilalazzam.recite.R
import com.bilalazzam.recite.feature_recite.presentation.moshafContent.jozzaIndex.JozzaItem
import com.bilalazzam.recite.feature_recite.presentation.shared.NumberView

@Composable
fun PageIndexScreen(
    onPageClick: (Int) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        contentPadding = PaddingValues(8.dp)
    ) {

        val pages = mutableListOf<Int>()
        for (i in 1..604) {
            pages.add(i)
        }

        items(pages) {pageNumber ->
            PageItem(
                pageNumber = pageNumber,
                modifier = Modifier
                    .clickable { onPageClick(pageNumber) }
            )
        }
    }
}

@Composable
fun PageItem(
    pageNumber: Int,
    modifier: Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .border(width = 1.dp, color = MaterialTheme.colorScheme.tertiary)
            .padding(8.dp)
    ) {
        Text(
            text = stringResource(R.string.the_page),
            modifier = Modifier.align(Alignment.CenterStart),
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.secondaryContainer
        )
        NumberView(
            number = pageNumber,
            modifier = Modifier.align(Alignment.CenterEnd)
        )
    }
}
