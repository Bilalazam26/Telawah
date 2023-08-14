package com.bilalazzam.recite.feature_recite.presentation.moshafContent

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.bilalazzam.recite.R
import com.bilalazzam.recite.feature_recite.presentation.shared.SearchBar
import com.bilalazzam.recite.feature_recite.presentation.moshafContent.components.TabLayout
import com.bilalazzam.recite.feature_recite.presentation.util.TabItem

@Composable
fun MoshafContentScreen(
    modifier: Modifier = Modifier,
    onItemClick: (Int) -> Unit,
    onSearchClick: () -> Unit
) {
    val tabs = listOf(
        TabItem.SorahIndex(stringResource(id = R.string.sorah_index)),
        TabItem.JozzaIndex(stringResource(id = R.string.jozza_index)),
        TabItem.PageIndex(stringResource(id = R.string.pages))
    )
    Column(
        modifier = modifier.padding(8.dp)
    ) {
        SearchBar(
            value = "",
            label = stringResource(id = R.string.search_by_ayah),
            onValueChange = {},
            backgroundColor = MaterialTheme.colorScheme.primary.copy(alpha = .3f),
            contentColor = MaterialTheme.colorScheme.secondaryContainer,
            modifier = Modifier.clickable {
                onSearchClick()
            }
        )
        Spacer(modifier = Modifier.height(8.dp))
        TabLayout(
            tabs = tabs,
            onItemClick = onItemClick
        )
    }

}

