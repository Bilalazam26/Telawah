package com.bilalazzam.recite.feature_recite.presentation.moshaf

import android.util.Log
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

private const val TAG = "AlMoshafViewModel"

@HiltViewModel
class AlMoshafViewModel @Inject constructor(
    private val reciteUseCases: ReciteUseCases
): ViewModel() {

    private val _bookmarkedPage: MutableState<Int?> = mutableStateOf(reciteUseCases.getBookmarkedPage())
    val bookmarkedPage: State<Int?> = _bookmarkedPage

    private val _currentPage: MutableState<Int?> = mutableStateOf(reciteUseCases.getCurrentPage())
    val currentPage: State<Int?> = _currentPage


    fun setBookmarkedPage(pageNumber: Int) {
        reciteUseCases.setBookmarkedPage(pageNumber)
        _bookmarkedPage.value = reciteUseCases.getBookmarkedPage()
        Log.d(TAG, "pageNumber: $pageNumber")
        Log.d(TAG, "setBookmarkedPage: ${bookmarkedPage.value}")
        Log.d(TAG, "setBookmarkedPage: ${_bookmarkedPage.value}")
    }

    fun setCurrentPage(currentPage: Int) {
        reciteUseCases.setCurrentPage(currentPage)
        _currentPage.value = reciteUseCases.getCurrentPage()
    }

    fun quranPages(): List<Page> {
        return reciteUseCases.getAllQuranPages()
    }


}