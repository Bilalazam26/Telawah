package com.bilalazzam.recite.feature_recite.domain.useCase

import com.bilalazzam.recite.feature_recite.domain.repository.AlMoshafRepository

class SetBookmarkedPage(private val repository: AlMoshafRepository) {
    operator fun invoke(pageNumber: Int) = repository.setBookmarkedPage(pageNumber)
}