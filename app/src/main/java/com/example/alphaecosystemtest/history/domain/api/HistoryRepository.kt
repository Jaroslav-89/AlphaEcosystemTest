package com.example.alphaecosystemtest.history.domain.api

import com.example.alphaecosystemtest.common.domain.model.CardInfo
import kotlinx.coroutines.flow.Flow

interface HistoryRepository {
    fun getSearchHistory(): Flow<List<CardInfo>>
}