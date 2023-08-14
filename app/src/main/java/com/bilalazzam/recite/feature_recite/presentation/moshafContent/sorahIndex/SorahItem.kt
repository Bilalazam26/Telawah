package com.bilalazzam.recite.feature_recite.presentation.moshafContent.sorahIndex


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.bilalazzam.recite.R
import com.bilalazzam.recite.feature_recite.domain.model.Sorah
import com.bilalazzam.recite.feature_recite.presentation.shared.NumberView

@Composable
fun SorahItem(
    sorah: Sorah,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = sorah.sorahNumber.toString(),
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.secondaryContainer
        )
        Text(
            text = sorah.sorahNameAr,
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.secondaryContainer
        )
        NumberView(number = sorah.startPage)

    }

}