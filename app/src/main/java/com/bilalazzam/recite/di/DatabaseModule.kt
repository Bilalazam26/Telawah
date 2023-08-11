package com.bilalazzam.recite.di

import android.app.Application
import com.bilalazzam.recite.feature_recite.data.dataSource.local.QuranDatabase
import com.bilalazzam.recite.feature_recite.data.repository.AlMoshafRepositoryImpl
import com.bilalazzam.recite.feature_recite.domain.repository.AlMoshafRepository
import com.bilalazzam.recite.feature_recite.domain.useCase.GetAllQuranPages
import com.bilalazzam.recite.feature_recite.domain.useCase.GetSorahList
import com.bilalazzam.recite.feature_recite.domain.useCase.ReciteUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideQuranDatabase(app: Application): QuranDatabase {
        return QuranDatabase.quranDatabaseInstance(app)
    }

}