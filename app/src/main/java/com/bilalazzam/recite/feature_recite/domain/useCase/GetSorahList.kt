package com.bilalazzam.recite.feature_recite.domain.useCase

import com.bilalazzam.recite.feature_recite.domain.model.Sorah
import com.bilalazzam.recite.feature_recite.domain.repository.MoshafContentRepository

class GetSorahList(private val repository: MoshafContentRepository) {
    suspend operator fun invoke(): List<Sorah> = repository.getSorahList()
}