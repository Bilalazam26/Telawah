package com.bilalazzam.recite.feature_recite.presentation.shared

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.bilalazzam.recite.R

@Composable
fun NumberView(
    number: Int,
    containerColor: Color = MaterialTheme.colorScheme.primary,
    contentColor: Color = MaterialTheme.colorScheme.secondaryContainer,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(id = R.drawable.number_container),
            contentDescription = null,
            modifier = Modifier.sizeIn(minWidth = 36.dp, minHeight = 36.dp, maxWidth = 48.dp, maxHeight = 48.dp),
            tint = containerColor
        )
        Text(text = "$number", color = contentColor)
    }
}