package com.bilalazzam.recite.feature_recite.domain.model

data class Sorah(
    val sorahNumber: Int,
    val startPage: Int,
    val endPage: Int,
    val sorahNameAr: String,
    val sorahNameEn: String
)
