package com.example.alphaecosystemtest.history.ui.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.alphaecosystemtest.history.domain.api.HistoryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(private val historyUseCase: HistoryUseCase) :
    ViewModel() {

    private val _screenState: MutableLiveData<HistoryScreenState> =
        MutableLiveData(HistoryScreenState.Loading)
    val screenState: LiveData<HistoryScreenState> = _screenState

    init {
        viewModelScope.launch {
            renderState(HistoryScreenState.Loading)
            historyUseCase.getSearchHistory().collect {
                if (it.isNotEmpty()) {
                    renderState(HistoryScreenState.Content(cardInfoList = it))
                } else {
                    renderState(HistoryScreenState.Empty)
                }
            }
        }
    }

    private fun renderState(state: HistoryScreenState) {
        _screenState.postValue(state)
    }
}