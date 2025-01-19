package com.example.alphaecosystemtest.common.ui.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.alphaecosystemtest.R

sealed class BottomNavItem(@StringRes val title: Int, val icon: ImageVector, var route: String) {
    object Search : BottomNavItem(R.string.search, Icons.Filled.Search, "search")
    object History : BottomNavItem(R.string.history, Icons.Filled.Star, "history")
}