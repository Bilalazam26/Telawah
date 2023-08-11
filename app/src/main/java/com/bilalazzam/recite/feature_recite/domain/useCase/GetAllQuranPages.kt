package com.bilalazzam.recite.feature_recite.domain.useCase

import com.bilalazzam.recite.feature_recite.domain.model.Page
import com.bilalazzam.recite.feature_recite.domain.repository.AlMoshafRepository

class GetAllQuranPages(private val repository: AlMoshafRepository) {
    operator fun invoke(): List<Page> {
        return repository.getAllQuranPages()
    }
}