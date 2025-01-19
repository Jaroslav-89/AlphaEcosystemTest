package com.example.alphaecosystemtest.history.domain.impl

import com.example.alphaecosystemtest.history.domain.api.HistoryRepository
import com.example.alphaecosystemtest.history.domain.api.HistoryUseCase
import com.example.alphaecosystemtest.common.domain.model.CardInfo
import kotlinx.coroutines.flow.Flow

class HistoryUseCaseImpl(private val repository: HistoryRepository) : HistoryUseCase {
    override fun getSearchHistory(): Flow<List<CardInfo>> {
        return repository.getSearchHistory()
    }
}