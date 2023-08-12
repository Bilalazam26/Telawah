package com.bilalazzam.recite.feature_recite.domain.useCase

import com.bilalazzam.recite.feature_recite.domain.repository.AlMoshafRepository

class GetBookmarkedPage(private val repository: AlMoshafRepository) {
    operator fun invoke(): Int? = repository.getBookmarkedPage()
}