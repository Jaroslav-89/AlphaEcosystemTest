package com.example.alphaecosystemtest.search.ui.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.alphaecosystemtest.common.utill.NetworkResult
import com.example.alphaecosystemtest.search.domain.api.SearchUseCase
import com.example.alphaecosystemtest.common.domain.model.CardInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(private val searchUseCase: SearchUseCase) : ViewModel() {
    private val _screenState: MutableLiveData<SearchScreenState> =
        MutableLiveData(SearchScreenState.Default)
    val screenState: LiveData<SearchScreenState> = _screenState

    fun searchCardInfo(cardNumber: String) {
        if (cardNumber.isNotBlank()) {
            _screenState.value = SearchScreenState.Loading
            viewModelScope.launch {
                searchUseCase.searchCardInfo(cardNumber).collect {
                    processResult(result = it)
                }
            }
        } else _screenState.value = SearchScreenState.CardInfoNotFound
    }

    private fun processResult(result: NetworkResult<CardInfo>) {
        when (result) {
            is NetworkResult.Success -> {
                val cardInfo = result.data
                if (cardInfo != null && cardInfo.isNotEmpty) {
                    renderState(SearchScreenState.Content(cardInfo = cardInfo))
                } else {
                    renderState(SearchScreenState.CardInfoNotFound)
                }
            }

            is NetworkResult.Error -> {
                renderState(SearchScreenState.SearchError(result.errorType!!))
            }
        }
    }

    private fun renderState(state: SearchScreenState) {
        _screenState.postValue(state)
    }
}