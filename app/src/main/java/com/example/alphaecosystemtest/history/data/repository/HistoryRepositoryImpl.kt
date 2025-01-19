package com.example.alphaecosystemtest.history.data.repository

import com.example.alphaecosystemtest.common.data.converters.CardInfoConverter
import com.example.alphaecosystemtest.common.data.db.AppDataBase
import com.example.alphaecosystemtest.history.domain.api.HistoryRepository
import com.example.alphaecosystemtest.common.domain.model.CardInfo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class HistoryRepositoryImpl(private val dataBase: AppDataBase) : HistoryRepository {
    override fun getSearchHistory(): Flow<List<CardInfo>> {
        return dataBase.historyDao().getAllCardsInfo().map(CardInfoConverter::mapList)
    }
}