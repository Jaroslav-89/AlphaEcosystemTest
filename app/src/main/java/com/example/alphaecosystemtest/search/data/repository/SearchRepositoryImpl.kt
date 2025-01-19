package com.example.alphaecosystemtest.search.data.repository

import com.example.alphaecosystemtest.common.data.converters.CardInfoConverter
import com.example.alphaecosystemtest.common.data.db.AppDataBase
import com.example.alphaecosystemtest.common.domain.model.CardInfo
import com.example.alphaecosystemtest.common.utill.ErrorType
import com.example.alphaecosystemtest.common.utill.NetworkResult
import com.example.alphaecosystemtest.search.data.network.RetrofitNetworkClient
import com.example.alphaecosystemtest.search.data.network.dto.CardInfoResponse
import com.example.alphaecosystemtest.search.data.network.dto.CardInfoSearchRequest
import com.example.alphaecosystemtest.search.domain.api.SearchRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SearchRepositoryImpl(
    private val networkClient: RetrofitNetworkClient,
    private val dataBase: AppDataBase,
) : SearchRepository {
    override fun searchCardInfo(cardNumber: String): Flow<NetworkResult<CardInfo>> = flow {
        val response = networkClient.doRequest(CardInfoSearchRequest(cardNumber))

        when (response.resultCode) {
            -1 -> {
                emit(NetworkResult.Error(ErrorType.NO_INTERNET))
            }

            200 -> {
                val data = CardInfoConverter.map(response as CardInfoResponse)
                emit(NetworkResult.Success(data = data.copy(searchCardNumber = cardNumber)))

                if (data.isNotEmpty) {
                    dataBase.historyDao()
                        .insertCardInfo(CardInfoConverter.map(data.copy(searchCardNumber = cardNumber)))
                }
            }

            404 -> {
                emit(NetworkResult.Error(ErrorType.NON_200_RESPONSE))
            }

            else -> {
                emit(NetworkResult.Error(ErrorType.SERVER_THROWABLE))
            }
        }
    }
}