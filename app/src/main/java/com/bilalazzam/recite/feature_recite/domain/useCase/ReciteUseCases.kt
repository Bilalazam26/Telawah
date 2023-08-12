package com.bilalazzam.recite.feature_recite.domain.useCase

data class ReciteUseCases(
    val getAllQuranPages: GetAllQuranPages,
    val getSorahList: GetSorahList,
    val getJozzaList: GetJozzaList,
    val getAyatBySubtext: GetAyatBySubtext,
    val getCurrentPage: GetCurrentPage,
    val setCurrentPage: SetCurrentPage,
    val getBookmarkedPage: GetBookmarkedPage,
    val setBookmarkedPage: SetBookmarkedPage
)
