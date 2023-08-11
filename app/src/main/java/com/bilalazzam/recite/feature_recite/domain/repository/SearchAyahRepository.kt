package com.bilalazzam.recite.feature_recite.domain.repository

import com.bilalazzam.recite.feature_recite.domain.model.entity.Ayah

interface SearchAyahRepository {
    suspend fun getAyatBySubtext(subtext: String): List<Ayah>
}