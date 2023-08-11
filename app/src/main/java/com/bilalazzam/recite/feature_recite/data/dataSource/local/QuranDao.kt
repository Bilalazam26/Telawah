package com.bilalazzam.recite.feature_recite.data.dataSource.local

import androidx.room.Dao
import androidx.room.Query
import com.bilalazzam.recite.feature_recite.domain.model.Jozza
import com.bilalazzam.recite.feature_recite.domain.model.Sorah
import com.bilalazzam.recite.feature_recite.domain.model.entity.Ayah


@Dao
interface QuranDao {

    @Query("Select sora as sorahNumber," +
            " MIN(page) as startPage," +
            " MAX(page) as endPage," +
            " sora_name_ar as sorahNameAr," +
            " sora_name_en as sorahNameEn FROM quran WHERE sora = :sorahNumber")
    suspend fun getSorahByNumber(sorahNumber: Int): Sorah

    @Query("SELECT jozz as jozzaNumber, MIN(page) as startPage, MAX(page) as endPage FROM quran WHERE jozz = :jozzaNumber")
    suspend fun getJozzaByNumber(jozzaNumber: Int): Jozza

    @Query("SELECT * FROM quran WHERE aya_text_emlaey LIKE '%' || :subtext || '%'")
    suspend fun getAyatBySubtext(subtext: String): List<Ayah>
}