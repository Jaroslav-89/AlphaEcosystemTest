package com.example.alphaecosystemtest.search.domain.api

import com.example.alphaecosystemtest.common.utill.NetworkResult
import com.example.alphaecosystemtest.common.domain.model.CardInfo
import kotlinx.coroutines.flow.Flow

interface SearchUseCase {
    fun searchCardInfo(cardNumber: String): Flow<NetworkResult<CardInfo>>
}