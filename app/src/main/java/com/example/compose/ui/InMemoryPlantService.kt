package com.example.compose.ui

import com.example.compose.PlantRepository
import com.example.compose.PlantTheme
import com.example.compose.defaultPlantTheme
import com.example.compose.homeGardenThemes
import kotlinx.coroutines.delay

class InMemoryPlantService : PlantRepository {

    override suspend fun fetchThemes(): List<PlantTheme> {
        delay(5000)
        return defaultPlantTheme
    }

    override suspend fun fetchHomeGardenItems(): List<PlantTheme> {
        return homeGardenThemes
    }
}