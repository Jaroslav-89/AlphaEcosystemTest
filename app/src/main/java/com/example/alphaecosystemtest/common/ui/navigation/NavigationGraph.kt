package com.example.alphaecosystemtest.common.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.alphaecosystemtest.history.ui.HistoryScreen
import com.example.alphaecosystemtest.search.ui.SearchScreen

@Composable
fun NavigationGraph(navController: NavHostController, innerPadding: PaddingValues) {
    NavHost(navController, startDestination = BottomNavItem.Search.route) {
        composable(BottomNavItem.Search.route) {
            SearchScreen()
        }
        composable(BottomNavItem.History.route) {
            HistoryScreen(innerPadding = innerPadding)
        }
    }
}