package com.bilalazzam.recite.feature_recite.presentation.moshafContent.jozzaIndex

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.bilalazzam.recite.feature_recite.domain.model.Jozza
import com.bilalazzam.recite.feature_recite.presentation.shared.NumberView
import com.bilalazzam.recite.feature_recite.presentation.util.numberToString

@Composable
fun JozzaItem(
    jozza: Jozza,
    context: Context,
    modifier: Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = numberToString(context, jozza.jozzaNumber),
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.secondaryContainer
        )
        NumberView(number = jozza.startPage)
    }
}