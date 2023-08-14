package com.bilalazzam.recite.feature_recite.presentation.moshafContent.searchByAyah

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.bilalazzam.recite.R
import com.bilalazzam.recite.feature_recite.presentation.shared.SearchBar

@Composable
fun SearchScreen(
    modifier: Modifier = Modifier,
    onAyahClick: (Int) -> Unit,
    navController: NavHostController,
    viewModel: SearchAyahViewModel = hiltViewModel()
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Box(modifier = Modifier.fillMaxWidth()) {
                        Text(
                            text = stringResource(id = R.string.search_for_ayah),
                            modifier = Modifier
                                .align(Alignment.Center)
                                .padding(start = 8.dp),
                            style = MaterialTheme.typography.headlineMedium
                        )
                    }
                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            navController.navigateUp()
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = stringResource(R.string.back)
                        )
                    }
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary.copy(alpha = .2f),
                    titleContentColor = MaterialTheme.colorScheme.secondaryContainer,
                    navigationIconContentColor = MaterialTheme.colorScheme.secondaryContainer
                )
            )
        }
    ) {paddingValues ->
        Surface(
            modifier = Modifier.padding(paddingValues)
        ) {
            Column(
                modifier = modifier.padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                SearchBar(
                    value = viewModel.subtext.value,
                    label = stringResource(id = R.string.search_by_ayah),
                    onValueChange = {
                        viewModel.setSearchKeyword(it)
                        viewModel.getAyatBySubtext()
                    },
                    backgroundColor = MaterialTheme.colorScheme.primary.copy(alpha = .2f),
                    contentColor = MaterialTheme.colorScheme.secondaryContainer,
                    enabled = true
                )
                Spacer(modifier = Modifier.height(8.dp))
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentPadding = PaddingValues(8.dp)
                ) {
                    items(viewModel.searchResultAyat.value) {ayah ->
                        AyahItem(
                            ayah = ayah,
                            modifier = Modifier.clickable {
                                onAyahClick(ayah.page)
                            }
                        )
                    }
                }

            }
        }
    }

}