package com.example.alphaecosystemtest.history.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.alphaecosystemtest.common.domain.model.CardInfo
import com.example.alphaecosystemtest.common.ui.CardInfoItem
import com.example.alphaecosystemtest.common.ui.Loading
import com.example.alphaecosystemtest.history.ui.view_model.HistoryScreenState
import com.example.alphaecosystemtest.history.ui.view_model.HistoryViewModel

@Composable
fun HistoryScreen(viewModel: HistoryViewModel = hiltViewModel(), innerPadding: PaddingValues) {
    val screenState = viewModel.screenState.observeAsState(HistoryScreenState.Loading)

    when (val state = screenState.value) {
        is HistoryScreenState.Loading -> {
            Loading()
        }

        is HistoryScreenState.Content -> {
            CardInfoList(cardInfoList = state.cardInfoList, innerPadding)
        }

        is HistoryScreenState.Empty -> {
            Text(
                text = "No history available",
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize()
            )
        }
    }
}

@Composable
fun CardInfoList(cardInfoList: List<CardInfo>, innerPadding: PaddingValues) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                top = innerPadding.calculateTopPadding(),
                bottom = innerPadding.calculateBottomPadding()
            ),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(cardInfoList) { cardInfo ->
            CardInfoItem(cardInfo = cardInfo)
            HorizontalDivider(thickness = 2.dp)
        }
    }
}




