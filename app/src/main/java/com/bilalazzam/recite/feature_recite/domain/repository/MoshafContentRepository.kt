package com.bilalazzam.recite.feature_recite.domain.repository

import com.bilalazzam.recite.feature_recite.domain.model.Jozza
import com.bilalazzam.recite.feature_recite.domain.model.Sorah

interface MoshafContentRepository {
    suspend fun getSorahList(): List<Sorah>
    suspend fun getJozzaList(): List<Jozza>
}