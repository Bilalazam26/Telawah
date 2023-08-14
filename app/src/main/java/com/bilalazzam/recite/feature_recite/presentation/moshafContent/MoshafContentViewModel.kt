package com.bilalazzam.recite.feature_recite.presentation.moshafContent

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bilalazzam.recite.feature_recite.domain.model.Jozza
import com.bilalazzam.recite.feature_recite.domain.model.Sorah
import com.bilalazzam.recite.feature_recite.domain.useCase.ReciteUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoshafContentViewModel @Inject constructor(
    private val reciteUseCases: ReciteUseCases
): ViewModel() {

    private val _sorahListState = mutableStateOf(listOf<Sorah>())
    val sorahListState: State<List<Sorah>> = _sorahListState

    private val _jozzaListState = mutableStateOf(listOf<Jozza>())
    val jozzaListState: State<List<Jozza>> = _jozzaListState

    init {
        viewModelScope.launch {
            _sorahListState.value = reciteUseCases.getSorahList()
            _jozzaListState.value = reciteUseCases.getJozzaList()
        }
    }

}