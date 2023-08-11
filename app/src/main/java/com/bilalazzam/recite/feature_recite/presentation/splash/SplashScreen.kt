package com.bilalazzam.recite.feature_recite.presentation.splash

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bilalazzam.recite.R
import com.bilalazzam.recite.ui.theme.ReciteTheme

@Composable
fun SplashScreen() {
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = MaterialTheme.colorScheme.primary
    ) {
        Box(modifier = Modifier
            .wrapContentSize()
            .clip(CircleShape)
            .background(Color.White)
            .padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.recite_logo),
                contentDescription = "Recite Logo",
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(16.dp)
            )
        }
    }
}

@Preview(showBackground = true,
    device = "spec:width=1080px,height=2340px,dpi=409", showSystemUi = true,
    name = "realme 3 pro Android 13",
    uiMode = Configuration.UI_MODE_TYPE_NORMAL
)
@Composable
fun PreviewSplashScreen() {
    ReciteTheme {
        SplashScreen()
    }
}