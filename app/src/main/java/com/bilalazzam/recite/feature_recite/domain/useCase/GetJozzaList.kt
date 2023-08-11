package com.bilalazzam.recite.feature_recite.domain.useCase

import com.bilalazzam.recite.feature_recite.domain.model.Jozza
import com.bilalazzam.recite.feature_recite.domain.repository.MoshafContentRepository

class GetJozzaList(private val repository: MoshafContentRepository) {
    suspend operator fun invoke(): List<Jozza> = repository.getJozzaList()
}