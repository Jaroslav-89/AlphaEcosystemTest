package com.example.alphaecosystemtest.history.domain.api

import com.example.alphaecosystemtest.common.domain.model.CardInfo
import kotlinx.coroutines.flow.Flow

interface HistoryUseCase {
    fun getSearchHistory(): Flow<List<CardInfo>>
}