package com.bilalazzam.recite.feature_recite.presentation.moshafContent.components.searchByAyah

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.bilalazzam.recite.R
import com.bilalazzam.recite.feature_recite.presentation.shared.SearchBar

private const val TAG = "SearchScreen"
@Composable
fun SearchScreen(
    modifier: Modifier = Modifier,
    onAyahClick: (Int) -> Unit,
    viewModel: SearchAyahViewModel = hiltViewModel()
) {
    Column(
        modifier = modifier.padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SearchBar(
            value = viewModel.subtext.value,
            label = stringResource(id = R.string.search_by_ayah),
            onValueChange = {
                viewModel.setSearchKeyword(it)
                viewModel.getAyatBySubtext()
            },
            backgroundColor = MaterialTheme.colorScheme.primary.copy(alpha = .2f),
            contentColor = MaterialTheme.colorScheme.secondaryContainer,
            enabled = true
        )
        Spacer(modifier = Modifier.height(8.dp))
        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            contentPadding = PaddingValues(8.dp)
        ) {
            items(viewModel.searchResultAyat.value) {ayah ->
                AyahItem(
                    ayah = ayah,
                    modifier = Modifier.clickable {
                        onAyahClick(ayah.page)
                    }
                )
            }
        }

    }
}