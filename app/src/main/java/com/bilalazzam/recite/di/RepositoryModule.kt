package com.bilalazzam.recite.di

import com.bilalazzam.recite.feature_recite.data.dataSource.local.QuranDatabase
import com.bilalazzam.recite.feature_recite.data.repository.AlMoshafRepositoryImpl
import com.bilalazzam.recite.feature_recite.data.repository.MoshafContentRepositoryImpl
import com.bilalazzam.recite.feature_recite.data.repository.SearchAyahRepositoryImpl
import com.bilalazzam.recite.feature_recite.domain.repository.AlMoshafRepository
import com.bilalazzam.recite.feature_recite.domain.repository.MoshafContentRepository
import com.bilalazzam.recite.feature_recite.domain.repository.SearchAyahRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideAlMoshafRepository(): AlMoshafRepository {
        return AlMoshafRepositoryImpl()
    }

    @Provides
    @Singleton
    fun provideMoshafContentRepository(db: QuranDatabase): MoshafContentRepository {
        return MoshafContentRepositoryImpl(db.quranDao)
    }

    @Provides
    @Singleton
    fun provideSearchAyahRepository(db: QuranDatabase): SearchAyahRepository {
        return SearchAyahRepositoryImpl(db.quranDao)
    }
}