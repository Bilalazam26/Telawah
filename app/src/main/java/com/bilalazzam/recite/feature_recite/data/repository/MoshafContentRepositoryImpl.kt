package com.bilalazzam.recite.feature_recite.data.repository

import com.bilalazzam.recite.feature_recite.data.dataSource.local.QuranDao
import com.bilalazzam.recite.feature_recite.domain.model.Jozza
import com.bilalazzam.recite.feature_recite.domain.model.Sorah
import com.bilalazzam.recite.feature_recite.domain.repository.MoshafContentRepository

class MoshafContentRepositoryImpl(
    private val dao: QuranDao
): MoshafContentRepository {
    override suspend fun getSorahList(): List<Sorah> {
        val sorahList = mutableListOf<Sorah>()
        for (i in 1..114) {
            sorahList.add(dao.getSorahByNumber(i))
        }
        return sorahList
    }

    override suspend fun getJozzaList(): List<Jozza> {
        val jozzaList = mutableListOf<Jozza>()
        for (i in 1..30) {
            jozzaList.add(dao.getJozzaByNumber(i))
        }
        return jozzaList
    }
}