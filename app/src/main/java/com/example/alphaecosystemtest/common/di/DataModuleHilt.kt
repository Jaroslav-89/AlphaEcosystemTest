package com.jaroapps.availabledishes.common.di

import android.content.Context
import androidx.room.Room
import com.example.alphaecosystemtest.common.data.db.AppDataBase
import com.example.alphaecosystemtest.search.data.network.BinListApiService
import com.example.alphaecosystemtest.search.data.network.RetrofitNetworkClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

private const val BIN_LIST_URL = "https://lookup.binlist.net"

@Module
@InstallIn(SingletonComponent::class)
class DataModuleHilt {

    @Provides
    @Singleton
    fun provideDataBase(@ApplicationContext context: Context): AppDataBase =
        Room.databaseBuilder(context, AppDataBase::class.java, "database.db")
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BIN_LIST_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): BinListApiService =
        retrofit.create(BinListApiService::class.java)

    @Provides
    @Singleton
    fun provideRetrofitClient(
        apiService: BinListApiService,
        @ApplicationContext context: Context
    ): RetrofitNetworkClient {
        return RetrofitNetworkClient(apiService, context)
    }
}