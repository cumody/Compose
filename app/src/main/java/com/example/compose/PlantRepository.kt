package com.example.compose

interface PlantRepository {

    suspend fun fetchThemes(): List<PlantTheme>
    suspend fun fetchHomeGardenItems(): List<PlantTheme>

}