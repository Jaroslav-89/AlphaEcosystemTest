package com.jaroapps.availabledishes.common.di

import com.example.alphaecosystemtest.history.domain.api.HistoryRepository
import com.example.alphaecosystemtest.history.domain.api.HistoryUseCase
import com.example.alphaecosystemtest.history.domain.impl.HistoryUseCaseImpl
import com.example.alphaecosystemtest.search.domain.api.SearchRepository
import com.example.alphaecosystemtest.search.domain.api.SearchUseCase
import com.example.alphaecosystemtest.search.domain.impl.SearchUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModuleHilt {
    @Provides
    @Singleton
    fun provideSearchUseCase(
        repository: SearchRepository
    ): SearchUseCase =
        SearchUseCaseImpl(
            repository
        )

    @Provides
    @Singleton
    fun provideHistoryUseCase(
        repository: HistoryRepository
    ): HistoryUseCase =
        HistoryUseCaseImpl(
            repository
        )
}
