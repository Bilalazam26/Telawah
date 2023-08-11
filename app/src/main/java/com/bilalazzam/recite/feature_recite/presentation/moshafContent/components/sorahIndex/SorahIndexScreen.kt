package com.bilalazzam.recite.feature_recite.presentation.moshafContent.components.sorahIndex

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.bilalazzam.recite.R
import com.bilalazzam.recite.feature_recite.domain.model.Sorah

@Composable
fun SorahIndexScreen(
    sorahList: List<Sorah>,
    onSorahClick: (Int) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.tertiary)
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = stringResource(R.string.sorah_number),
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.secondaryContainer
                )
                Text(
                    text = stringResource(R.string.sorah_name),
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.secondaryContainer
                )
                Text(
                    text = stringResource(R.string.page_number),
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.secondaryContainer
                )
            }
        }
        items(sorahList) {sorah ->
            SorahItem(
                sorah = sorah,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        onSorahClick(sorah.startPage)
                    }
                    .border(
                        width = 1.dp,
                        color = MaterialTheme.colorScheme.tertiary
                    )
                    .padding(8.dp)
            )
        }
    }

}