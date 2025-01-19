package com.example.alphaecosystemtest.search.data.network

import com.example.alphaecosystemtest.search.data.network.dto.CardInfoSearchRequest
import com.example.alphaecosystemtest.search.data.network.dto.Response

interface NetworkClient {
    suspend fun doRequest(dto: CardInfoSearchRequest): Response
}