package com.example.alphaecosystemtest.common.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.alphaecosystemtest.R
import com.example.alphaecosystemtest.common.ui.theme.YpBlue
import com.example.alphaecosystemtest.common.domain.model.CardInfo

@Composable
fun CardInfoItem(cardInfo: CardInfo) {
    Column(modifier = Modifier.padding(8.dp)) {
        Text(
            text = stringResource(id = R.string.search_card_number) + "" + cardInfo.searchCardNumber
        )
        Text(
            text = stringResource(id = R.string.card_number_length) + "" + cardInfo.cardNumberLength
        )
        Text(
            text = stringResource(id = R.string.card_number_luhn) + "" + cardInfo.cardNumberLuhn
        )
        Text(
            text = stringResource(id = R.string.scheme) + "" + cardInfo.scheme
        )
        Text(
            text = stringResource(id = R.string.type) + "" + cardInfo.type
        )
        Text(
            text = stringResource(id = R.string.brand) + "" + cardInfo.brand
        )
        Text(
            text = stringResource(id = R.string.prepaid) + "" + cardInfo.prepaid
        )
        Text(
            text = stringResource(id = R.string.country) + "" + cardInfo.countryNumeric + ""
                    + cardInfo.countryAlpha2 + "" + cardInfo.countryName + "" + cardInfo.countryEmoji
        )
        Text(
            text = stringResource(id = R.string.country_currency) + "" + cardInfo.countryCurrency
        )
        Text(
            text = stringResource(id = R.string.country_coordinates) + "" + cardInfo.countryLatitude
                    + "" + cardInfo.countryLongitude
        )
        Text(
            text = stringResource(id = R.string.bank) + "" + cardInfo.bankName + "" + cardInfo.bankUrl
                    + "" + cardInfo.bankPhone + "" + cardInfo.bankCity
        )
    }
}

@Composable
fun Loading() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CircularProgressIndicator(
            modifier = Modifier
                .size(44.dp),
            color = YpBlue,
        )
    }
}
