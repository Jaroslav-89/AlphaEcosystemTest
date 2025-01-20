package com.example.alphaecosystemtest.common.domain.model

data class CardInfo(
    val searchCardNumber: String,
    val cardNumberLength: Int = 0,
    val cardNumberLuhn: Boolean = false,
    val scheme: String = "",
    val type: String = "",
    val brand: String = "",
    val prepaid: Boolean = false,
    val countryNumeric: String = "",
    val countryAlpha2: String = "",
    val countryName: String = "",
    val countryEmoji: String = "",
    val countryCurrency: String = "",
    val countryLatitude: String = "",
    val countryLongitude: String = "",
    val bankName: String = "",
    val bankUrl: String = "",
    val bankPhone: String = "",
    val bankCity: String = "",
) {
    val isNotEmpty: Boolean
        get() = cardNumberLength != 0 ||
                cardNumberLuhn ||
                scheme.isNotBlank() ||
                type.isNotBlank() ||
                brand.isNotBlank() ||
                prepaid ||
                countryNumeric.isNotBlank() ||
                countryAlpha2.isNotBlank() ||
                countryName.isNotBlank() ||
                countryEmoji.isNotBlank() ||
                countryCurrency.isNotBlank() ||
                countryLatitude.isNotBlank() ||
                countryLongitude.isNotBlank() ||
                bankName.isNotBlank() ||
                bankUrl.isNotBlank() ||
                bankPhone.isNotBlank() ||
                bankCity.isNotBlank()
}
