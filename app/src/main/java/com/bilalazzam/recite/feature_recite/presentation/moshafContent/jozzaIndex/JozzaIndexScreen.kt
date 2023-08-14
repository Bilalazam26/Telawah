package com.bilalazzam.recite.feature_recite.presentation.moshafContent.jozzaIndex

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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.bilalazzam.recite.R
import com.bilalazzam.recite.feature_recite.domain.model.Jozza

@Composable
fun JozzaIndexScreen(
    jozzaList: List<Jozza>,
    onJozzaClick: (Int) -> Unit
) {
    val context = LocalContext.current
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
                    text = stringResource(R.string.jozza_number),
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
        items(jozzaList) {jozza ->
            JozzaItem(
                jozza = jozza,
                context = context,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        onJozzaClick(jozza.startPage)
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


