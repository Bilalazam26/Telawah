package com.bilalazzam.recite.feature_recite.presentation.shared

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.bilalazzam.recite.R

@Composable
fun SearchBar(
    value: String,
    label:String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    backgroundColor: Color,
    contentColor: Color,
    enabled: Boolean = false
) {
    Surface(
        modifier = modifier.wrapContentHeight(),
        shape = RoundedCornerShape(16.dp)
    ) {

        TextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier.wrapContentHeight().fillMaxWidth(),
            label = {
                Text(text = label)
            },
            enabled = enabled,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null,
                    modifier = Modifier.padding(horizontal = 16.dp),
                    tint = contentColor
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = backgroundColor,
                cursorColor = contentColor,
                textColor = contentColor,
                disabledTextColor = contentColor,
                unfocusedIndicatorColor = contentColor,
                unfocusedSupportingTextColor = contentColor,
                unfocusedLabelColor = contentColor,
                focusedLabelColor = contentColor,
                focusedIndicatorColor = contentColor,
                disabledIndicatorColor = contentColor,
                disabledLabelColor = contentColor,
                disabledPlaceholderColor = contentColor
            )
        )
    }
}
