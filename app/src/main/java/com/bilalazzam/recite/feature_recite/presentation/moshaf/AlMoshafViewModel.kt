package com.bilalazzam.recite.feature_recite.presentation.moshaf

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.bilalazzam.recite.feature_recite.domain.model.Page
import com.bilalazzam.recite.feature_recite.domain.useCase.ReciteUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AlMoshafViewModel @Inject constructor(
    private val reciteUseCases: ReciteUseCases
): ViewModel() {

    fun quranPages(): List<Page> {
        return reciteUseCases.getAllQuranPages()
    }


}