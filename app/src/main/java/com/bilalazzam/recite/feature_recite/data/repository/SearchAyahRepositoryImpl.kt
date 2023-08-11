package com.bilalazzam.recite.feature_recite.data.repository

import com.bilalazzam.recite.feature_recite.data.dataSource.local.QuranDao
import com.bilalazzam.recite.feature_recite.domain.model.entity.Ayah
import com.bilalazzam.recite.feature_recite.domain.repository.SearchAyahRepository

class SearchAyahRepositoryImpl(
    private val dao: QuranDao
): SearchAyahRepository {
    override suspend fun getAyatBySubtext(subtext: String): List<Ayah> {
        return dao.getAyatBySubtext(subtext)
    }
}