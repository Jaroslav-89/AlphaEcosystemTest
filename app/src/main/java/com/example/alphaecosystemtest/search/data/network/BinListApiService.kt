package com.example.alphaecosystemtest.search.data.network

import com.example.alphaecosystemtest.search.data.network.dto.CardInfoResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface BinListApiService {
    @GET("/{card_number}")
    suspend fun searchCardInfo(@Path("card_number") cardNumber: String): CardInfoResponse
}