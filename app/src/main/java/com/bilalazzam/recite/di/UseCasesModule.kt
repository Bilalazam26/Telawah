package com.bilalazzam.recite.di

import com.bilalazzam.recite.feature_recite.domain.repository.AlMoshafRepository
import com.bilalazzam.recite.feature_recite.domain.repository.MoshafContentRepository
import com.bilalazzam.recite.feature_recite.domain.repository.SearchAyahRepository
import com.bilalazzam.recite.feature_recite.domain.useCase.GetAllQuranPages
import com.bilalazzam.recite.feature_recite.domain.useCase.GetAyatBySubtext
import com.bilalazzam.recite.feature_recite.domain.useCase.GetBookmarkedPage
import com.bilalazzam.recite.feature_recite.domain.useCase.GetCurrentPage
import com.bilalazzam.recite.feature_recite.domain.useCase.GetJozzaList
import com.bilalazzam.recite.feature_recite.domain.useCase.GetSorahList
import com.bilalazzam.recite.feature_recite.domain.useCase.ReciteUseCases
import com.bilalazzam.recite.feature_recite.domain.useCase.SetBookmarkedPage
import com.bilalazzam.recite.feature_recite.domain.useCase.SetCurrentPage
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCasesModule {

    @Provides
    @Singleton
    fun provideReciteUseCases(
        alMoshafRepository: AlMoshafRepository,
        moshafContentRepository: MoshafContentRepository,
        searchAyahRepository: SearchAyahRepository
    ): ReciteUseCases {
        return ReciteUseCases(
            GetAllQuranPages(alMoshafRepository),
            GetSorahList(moshafContentRepository),
            GetJozzaList(moshafContentRepository),
            GetAyatBySubtext(searchAyahRepository),
            GetCurrentPage(alMoshafRepository),
            SetCurrentPage(alMoshafRepository),
            GetBookmarkedPage(alMoshafRepository),
            SetBookmarkedPage(alMoshafRepository)
        )
    }
}