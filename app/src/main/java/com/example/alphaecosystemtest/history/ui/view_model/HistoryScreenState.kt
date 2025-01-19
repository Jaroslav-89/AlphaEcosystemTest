package com.example.alphaecosystemtest.history.ui.view_model

import com.example.alphaecosystemtest.common.domain.model.CardInfo

interface HistoryScreenState {
    object Loading : HistoryScreenState

    data class Content(val cardInfoList: List<CardInfo>) : HistoryScreenState

    object Empty : HistoryScreenState
}