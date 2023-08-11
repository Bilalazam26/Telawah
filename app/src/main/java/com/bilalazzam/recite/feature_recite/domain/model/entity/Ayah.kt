package com.bilalazzam.recite.feature_recite.domain.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "quran")
data class Ayah (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "jozz") val jozza: Int = 0,
    @ColumnInfo(name = "sora") val sorahNumber: Int = 0,
    @ColumnInfo(name = "sora_name_en") val sorahNameEn: String = "",
    @ColumnInfo(name = "sora_name_ar") val sorahNameAr: String = "",
    @ColumnInfo(name = "page") val page: Int = 0,
    @ColumnInfo(name = "line_start") val lineStart: Int = 0,
    @ColumnInfo(name = "line_end") val lineEnd: Int = 0,
    @ColumnInfo(name = "aya_no") val ayahNumber: Int = 0,
    @ColumnInfo(name = "aya_text") val ayahText: String = "",
    @ColumnInfo(name = "aya_text_emlaey") val ayahTextEmlaey: String = ""
)