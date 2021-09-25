package com.example.compose.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.compose.PlantRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val plantRepository: PlantRepository
) : ViewModel() {
    // state now is default homeViewState
    private val _viewState = MutableStateFlow(HomeViewState())
    val viewState: StateFlow<HomeViewState> = _viewState

    init {
        fetchPlantTheme()
        fetchHomeGardenItems()
    }

    private fun fetchPlantTheme() {
        viewModelScope.launch {
            val plantThemes = plantRepository.fetchThemes()
            // here we update our state
            _viewState.value = _viewState.value.copy(
                plantThemes = plantThemes
            )
        }
    }

    private fun fetchHomeGardenItems() {
        viewModelScope.launch {
            val homeGardenItems = plantRepository.fetchHomeGardenItems()

            _viewState.value = _viewState.value.copy(
                homeGardenItem = homeGardenItems
            )
        }
    }


}