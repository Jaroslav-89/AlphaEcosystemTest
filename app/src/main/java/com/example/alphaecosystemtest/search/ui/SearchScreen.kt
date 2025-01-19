package com.example.alphaecosystemtest.search.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.alphaecosystemtest.R
import com.example.alphaecosystemtest.common.ui.CardInfoItem
import com.example.alphaecosystemtest.common.ui.Loading
import com.example.alphaecosystemtest.common.utill.ErrorType
import com.example.alphaecosystemtest.search.ui.view_model.SearchScreenState
import com.example.alphaecosystemtest.search.ui.view_model.SearchViewModel

@Composable
fun SearchScreen(viewModel: SearchViewModel = hiltViewModel(), innerPadding: PaddingValues) {
    val screenState = viewModel.screenState.observeAsState(SearchScreenState.Default)
    val keyboardController = LocalSoftwareKeyboardController.current

    Column(
        modifier = Modifier
            .padding(
                top = innerPadding.calculateTopPadding() + 40.dp,
                bottom = innerPadding.calculateBottomPadding()
            )
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var text by rememberSaveable { mutableStateOf("") }

        TextField(
            value = text,
            maxLines = 1,
            label = {
                if (text.isBlank()) Text(
                    text = stringResource(id = R.string.search_hint),
                    fontSize = 12.sp
                )
            },
            onValueChange = {
                text = it
            },
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Button(modifier = Modifier
            .height(60.dp)
            .width(140.dp),
            onClick = {
                viewModel.searchCardInfo(text)
                keyboardController?.hide()
            }) {
            Text(
                text = stringResource(id = R.string.search_btn),
                fontSize = 20.sp,
            )
        }

        when (val state = screenState.value) {
            is SearchScreenState.Default -> {

            }

            is SearchScreenState.Loading -> {
                Loading()
            }

            is SearchScreenState.Content -> {
                CardInfoItem(cardInfo = state.cardInfo)
            }

            is SearchScreenState.CardInfoNotFound -> {
                Text(
                    text = stringResource(id = R.string.nothing_found),
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(),
                    textAlign = TextAlign.Center,
                )
            }

            is SearchScreenState.SearchError -> {
                ShowError(state.type)
            }
        }
    }
}

@Composable
fun ShowError(type: ErrorType) {
    when (type) {
        ErrorType.NO_INTERNET -> {
            Text(
                text = stringResource(id = R.string.internet_throwable),
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(),
                textAlign = TextAlign.Center,
            )
        }

        ErrorType.NON_200_RESPONSE -> {
            Text(
                text = stringResource(id = R.string.search_error),
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(),
                textAlign = TextAlign.Center,
            )
        }

        ErrorType.SERVER_THROWABLE -> {
            Text(
                text = stringResource(id = R.string.server_error),
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(),
                textAlign = TextAlign.Center,
            )
        }
    }
}

