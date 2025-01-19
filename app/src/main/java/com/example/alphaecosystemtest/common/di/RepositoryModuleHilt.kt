package com.jaroapps.availabledishes.common.di

import com.example.alphaecosystemtest.common.data.db.AppDataBase
import com.example.alphaecosystemtest.history.data.repository.HistoryRepositoryImpl
import com.example.alphaecosystemtest.history.domain.api.HistoryRepository
import com.example.alphaecosystemtest.search.data.network.RetrofitNetworkClient
import com.example.alphaecosystemtest.search.data.repository.SearchRepositoryImpl
import com.example.alphaecosystemtest.search.domain.api.SearchRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModuleHilt {
    @Provides
    @Singleton
    fun provideSearchRepository(
        networkClient: RetrofitNetworkClient,
        dataBase: AppDataBase,
    ): SearchRepository =
        SearchRepositoryImpl(networkClient, dataBase)

    @Provides
    @Singleton
    fun provideHistoryRepository(
        dataBase: AppDataBase,
    ): HistoryRepository =
        HistoryRepositoryImpl(dataBase)
}