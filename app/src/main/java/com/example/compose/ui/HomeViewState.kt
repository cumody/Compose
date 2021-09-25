package com.example.compose.ui

import com.example.compose.PlantTheme

data class HomeViewState(
    val plantThemes : List<PlantTheme> = emptyList(),
    val homeGardenItem : List<PlantTheme> = emptyList()
) {

    val showLoading : Boolean
    get() = plantThemes.isEmpty() || homeGardenItem.isEmpty()
}