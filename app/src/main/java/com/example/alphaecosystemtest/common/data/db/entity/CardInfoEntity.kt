package com.example.alphaecosystemtest.common.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "card_info_table")
data class CardInfoEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo("search_card_number")
    val searchCardNumber: Int,
    @ColumnInfo("card_number_length")
    val cardNumberLength: Int,
    @ColumnInfo("card_number_luhn")
    val cardNumberLuhn: Boolean,
    val scheme: String,
    val type: String,
    val brand: String,
    val prepaid: Boolean,
    @ColumnInfo("country_numeric")
    val countryNumeric: String,
    @ColumnInfo("country_alpha2")
    val countryAlpha2: String,
    @ColumnInfo("country_name")
    val countryName: String,
    @ColumnInfo("country_emoji")
    val countryEmoji: String,
    @ColumnInfo("country_currency")
    val countryCurrency: String,
    @ColumnInfo("country_latitude")
    val countryLatitude: String,
    @ColumnInfo("country_longitude")
    val countryLongitude: String,
    @ColumnInfo("bank_name")
    val bankName: String,
    @ColumnInfo("bank_url")
    val bankUrl: String,
    @ColumnInfo("bank_phone")
    val bankPhone: String,
    @ColumnInfo("bank_city")
    val bankCity: String,
    @ColumnInfo("add_date")
    val addDate: Long,
)