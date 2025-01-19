package com.example.alphaecosystemtest.search.data.network

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.util.Log
import com.example.alphaecosystemtest.search.data.network.dto.CardInfoSearchRequest
import com.example.alphaecosystemtest.search.data.network.dto.Response
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException

class RetrofitNetworkClient(
    private val binListApiService: BinListApiService,
    private val context: Context,
) : NetworkClient {
    override suspend fun doRequest(dto: CardInfoSearchRequest): Response {
        if (!isConnected()) return Response().apply { resultCode = -1 }

        return withContext(Dispatchers.IO) {
            try {
                val response = binListApiService.searchCardInfo(dto.cardNumber)
                response.apply { resultCode = 200 }
            } catch (e1: IOException) {
                Log.e("TAG", e1.toString())
                Response().apply { resultCode = 500 }
            } catch (e2: HttpException) {
                Log.e("TAG", e2.toString())
                Response().apply { resultCode = 404 }
            }
        }
    }

    private fun isConnected(): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val capabilities =
            connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
        if (capabilities != null) {
            return when {
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                else -> false
            }
        }
        return false
    }
}