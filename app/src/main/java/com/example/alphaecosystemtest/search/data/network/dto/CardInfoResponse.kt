package com.example.alphaecosystemtest.search.data.network.dto

data class CardInfoResponse(
    val number: NumberInfoDto?,
    val scheme: String?,
    val type: String?,
    val brand: String?,
    val prepaid: Boolean?,
    val country: CountryInfoDto?,
    val bank: BankInfoDto?,
) : Response()