package com.example.alphaecosystemtest.search.domain.impl

import com.example.alphaecosystemtest.common.utill.NetworkResult
import com.example.alphaecosystemtest.search.domain.api.SearchRepository
import com.example.alphaecosystemtest.search.domain.api.SearchUseCase
import com.example.alphaecosystemtest.common.domain.model.CardInfo
import kotlinx.coroutines.flow.Flow

class SearchUseCaseImpl(private val repository: SearchRepository) : SearchUseCase {
    override fun searchCardInfo(cardNumber: String): Flow<NetworkResult<CardInfo>> {
        return repository.searchCardInfo(cardNumber)
    }
}