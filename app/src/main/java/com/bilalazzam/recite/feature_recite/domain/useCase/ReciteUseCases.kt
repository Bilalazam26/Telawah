package com.bilalazzam.recite.feature_recite.domain.useCase

data class ReciteUseCases(
    val getAllQuranPages: GetAllQuranPages,
    val getSorahList: GetSorahList,
    val getJozzaList: GetJozzaList,
    val getAyatBySubtext: GetAyatBySubtext
)
