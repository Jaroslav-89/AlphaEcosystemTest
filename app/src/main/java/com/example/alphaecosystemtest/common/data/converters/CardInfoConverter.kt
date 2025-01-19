package com.example.alphaecosystemtest.common.data.converters

import com.example.alphaecosystemtest.common.data.db.entity.CardInfoEntity
import com.example.alphaecosystemtest.search.data.network.dto.CardInfoResponse
import com.example.alphaecosystemtest.common.domain.model.CardInfo

object CardInfoConverter {
    fun map(cardInfoResponse: CardInfoResponse): CardInfo {
        return CardInfo(
            searchCardNumber = "0",
            cardNumberLength = cardInfoResponse.number?.length ?: 0,
            cardNumberLuhn = cardInfoResponse.number?.luhn ?: false,
            scheme = cardInfoResponse.scheme ?: "",
            type = cardInfoResponse.type ?: "",
            brand = cardInfoResponse.brand ?: "",
            prepaid = cardInfoResponse.prepaid ?: false,
            countryNumeric = cardInfoResponse.country?.numeric ?: "",
            countryAlpha2 = cardInfoResponse.country?.alpha2 ?: "",
            countryName = cardInfoResponse.country?.name ?: "",
            countryEmoji = cardInfoResponse.country?.emoji ?: "",
            countryCurrency = cardInfoResponse.country?.currency ?: "",
            countryLatitude = cardInfoResponse.country?.latitude.toSafeString(),
            countryLongitude = cardInfoResponse.country?.longitude.toSafeString(),
            bankName = cardInfoResponse.bank?.name ?: "",
            bankUrl = cardInfoResponse.bank?.url ?: "",
            bankPhone = cardInfoResponse.bank?.phone ?: "",
            bankCity = cardInfoResponse.bank?.city ?: "",
        )
    }

    fun map(cardInfo: CardInfo): CardInfoEntity {
        return CardInfoEntity(
            searchCardNumber = cardInfo.searchCardNumber.toInt(),
            cardNumberLength = cardInfo.cardNumberLength,
            cardNumberLuhn = cardInfo.cardNumberLuhn,
            scheme = cardInfo.scheme,
            type = cardInfo.type,
            brand = cardInfo.brand,
            prepaid = cardInfo.prepaid,
            countryNumeric = cardInfo.countryNumeric,
            countryAlpha2 = cardInfo.countryAlpha2,
            countryName = cardInfo.countryName,
            countryEmoji = cardInfo.countryEmoji,
            countryCurrency = cardInfo.countryCurrency,
            countryLatitude = cardInfo.countryLatitude,
            countryLongitude = cardInfo.countryLongitude,
            bankName = cardInfo.bankName,
            bankUrl = cardInfo.bankUrl,
            bankPhone = cardInfo.bankPhone,
            bankCity = cardInfo.bankCity,
            addDate = System.currentTimeMillis(),
        )
    }

    fun map(cardInfoEntity: CardInfoEntity): CardInfo {
        return CardInfo(
            searchCardNumber = cardInfoEntity.searchCardNumber.toString(),
            cardNumberLength = cardInfoEntity.cardNumberLength,
            cardNumberLuhn = cardInfoEntity.cardNumberLuhn,
            scheme = cardInfoEntity.scheme,
            type = cardInfoEntity.type,
            brand = cardInfoEntity.brand,
            prepaid = cardInfoEntity.prepaid,
            countryNumeric = cardInfoEntity.countryNumeric,
            countryAlpha2 = cardInfoEntity.countryAlpha2,
            countryName = cardInfoEntity.countryName,
            countryEmoji = cardInfoEntity.countryEmoji,
            countryCurrency = cardInfoEntity.countryCurrency,
            countryLatitude = cardInfoEntity.countryLatitude,
            countryLongitude = cardInfoEntity.countryLongitude,
            bankName = cardInfoEntity.bankName,
            bankUrl = cardInfoEntity.bankUrl,
            bankPhone = cardInfoEntity.bankPhone,
            bankCity = cardInfoEntity.bankCity,
        )
    }

    fun mapList(cardInfoEntityList: List<CardInfoEntity>): List<CardInfo> {
        val result = mutableListOf<CardInfo>()
        cardInfoEntityList.forEach { cardInfoEntity ->
            result.add(map(cardInfoEntity))
        }
        return result
    }

    private fun Double?.toSafeString(): String {
        return this?.toString() ?: ""
    }
}
