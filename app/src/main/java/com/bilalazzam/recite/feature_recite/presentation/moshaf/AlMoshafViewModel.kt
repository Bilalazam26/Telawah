package com.bilalazzam.recite.feature_recite.presentation.moshaf

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.MutableState
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
    //To Do: BookMarked Page has to be saved in the shared preferences

    private val _bookmarkedPage: MutableState<Int?> = mutableStateOf(null)
    val bookmarkedPage: State<Int?> = _bookmarkedPage

    fun setBookmarkedPage(pageNumber: Int) {
        _bookmarkedPage.value = pageNumber
    }

    fun quranPages(): List<Page> {
        return reciteUseCases.getAllQuranPages()
    }


}