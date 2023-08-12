package com.bilalazzam.recite.feature_recite.presentation.moshafContent

import android.content.Context
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
import com.bilalazzam.recite.R
import com.bilalazzam.recite.feature_recite.presentation.shared.SearchBar
import com.bilalazzam.recite.feature_recite.presentation.moshafContent.components.TabLayout
import com.bilalazzam.recite.feature_recite.presentation.util.TabItem

@Composable
fun MoshafContentScreen(
    modifier: Modifier = Modifier,
    moshafContentState: MoshafContentState,
    onItemClick: (Int) -> Unit,
    onSearchClick: () -> Unit,
    context: Context
) {
    val tabs = listOf(
        TabItem.SorahIndex(moshafContentState.sorahList, onItemClick, context),
        TabItem.JozzaIndex(moshafContentState.jozzaList, onItemClick, context),
        TabItem.PageIndex(onItemClick, context)
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
            tabs = tabs
        )
    }

}

