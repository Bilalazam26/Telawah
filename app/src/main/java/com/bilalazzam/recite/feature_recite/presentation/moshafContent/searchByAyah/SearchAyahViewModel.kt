package com.bilalazzam.recite.feature_recite.presentation.moshafContent.searchByAyah

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bilalazzam.recite.feature_recite.domain.model.entity.Ayah
import com.bilalazzam.recite.feature_recite.domain.useCase.ReciteUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchAyahViewModel @Inject constructor(
    private val reciteUseCases: ReciteUseCases
): ViewModel() {

    private val _searchResultAyat = mutableStateOf(listOf<Ayah>())
    val searchResultAyat: State<List<Ayah>> = _searchResultAyat

    private val _subtext = mutableStateOf("")
    val subtext: State<String> = _subtext

    fun setSearchKeyword(keyword: String) {
        _subtext.value = keyword
    }

    fun getAyatBySubtext() {
        viewModelScope.launch {
            _searchResultAyat.value = reciteUseCases.getAyatBySubtext(subtext.value)
        }
    }
}