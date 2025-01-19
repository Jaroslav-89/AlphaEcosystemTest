package com.example.alphaecosystemtest.search.ui.view_model

import com.example.alphaecosystemtest.common.utill.ErrorType
import com.example.alphaecosystemtest.common.domain.model.CardInfo

interface SearchScreenState {
    object Default : SearchScreenState

    object Loading : SearchScreenState

    data class Content(val cardInfo: CardInfo) : SearchScreenState

    object CardInfoNotFound : SearchScreenState

    data class SearchError(val type: ErrorType) : SearchScreenState
}