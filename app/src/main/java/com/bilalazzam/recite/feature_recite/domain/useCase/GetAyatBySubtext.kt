package com.bilalazzam.recite.feature_recite.domain.useCase

import com.bilalazzam.recite.feature_recite.domain.model.entity.Ayah
import com.bilalazzam.recite.feature_recite.domain.repository.SearchAyahRepository

class GetAyatBySubtext(private val repository: SearchAyahRepository) {
    suspend operator fun invoke(subtext: String): List<Ayah> = repository.getAyatBySubtext(subtext)
}