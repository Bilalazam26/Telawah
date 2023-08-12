package com.bilalazzam.recite.feature_recite.domain.repository

import android.content.Context
import com.bilalazzam.recite.feature_recite.domain.model.Page

interface AlMoshafRepository {
    fun getAllQuranPages(): List<Page>

    fun getCurrentPage(): Int?

    fun setCurrentPage(currentPage: Int)

    fun getBookmarkedPage(): Int?

    fun setBookmarkedPage(pageNumber: Int)
}