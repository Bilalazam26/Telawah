package com.bilalazzam.recite.feature_recite.presentation.moshafContent.components.searchByAyah

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.bilalazzam.recite.R
import com.bilalazzam.recite.feature_recite.domain.model.entity.Ayah
import com.bilalazzam.recite.feature_recite.presentation.shared.NumberView

@Composable
fun AyahItem(
    ayah: Ayah,
    modifier: Modifier
) {
    Surface(
        modifier = modifier.padding(8.dp),
        shape = RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp),
        color = MaterialTheme.colorScheme.primary.copy(alpha = .2f)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.primary.copy(alpha = 1f))
                    .padding(8.dp)
            ) {
                Text(
                    text = ayah.sorahNameAr,
                    modifier = Modifier.align(Alignment.CenterStart),
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.secondaryContainer
                )
                Row(
                    modifier = Modifier.align(Alignment.CenterEnd),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = stringResource(R.string.ayah_number),
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.secondaryContainer.copy(alpha = .7f)
                    )
                    NumberView(
                        number = ayah.ayahNumber,
                        containerColor = MaterialTheme.colorScheme.secondaryContainer.copy(alpha = .7f),
                        contentColor = MaterialTheme.colorScheme.secondaryContainer.copy(alpha = .7f)
                    )
                }
            }
            Text(
                text = ayah.ayahTextEmlaey,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(8.dp),
                style = MaterialTheme.typography.bodyLarge,
                color = Color.Black
            )
            NumberView(number = ayah.page)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}