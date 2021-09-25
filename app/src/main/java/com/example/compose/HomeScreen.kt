package com.example.compose

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.ui.HomeViewModel
import com.example.compose.ui.HomeViewState
import com.example.compose.ui.theme.ComposeTheme


@Composable
fun HomeScreen(homeViewModel: HomeViewModel) {

    // every time state changes we want the view to re-render homeScreen
    val currentState = homeViewModel.viewState.collectAsState()

    HomeScreenScaffold(state = currentState.value)

}

@Composable
private fun HomeScreenLoader(paddingValues: PaddingValues) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues = paddingValues)
    ) {
        CircularProgressIndicator(
            modifier = Modifier
                .wrapContentSize()
                .align(Alignment.Center)
        )
    }
}

@Composable
private fun HomeScreenScaffold(state: HomeViewState) {

    Scaffold(bottomBar = {
        ComposeBottomBar()

    }) { paddingValues ->
        if (state.showLoading) {
            HomeScreenLoader(paddingValues)
        } else {
            HomeScreenContent(
                paddingValues,
                state
            )
        }
    }


}

@Composable
private fun ComposeBottomBar() {
    BottomAppBar() {

        BloomBottomButton(
            selected = true,
            icon = Icons.Default.Home,
            label = "Home"
        )
        BloomBottomButton(
            selected = false,
            icon = Icons.Default.FavoriteBorder,
            label = "Favourites"
        )
        BloomBottomButton(
            selected = false,
            icon = Icons.Default.AccountCircle,
            label = "Profile"
        )
        BloomBottomButton(
            selected = false,
            icon = Icons.Default.ShoppingCart,
            label = "Home"
        )
    }

}

@Composable
private fun RowScope.BloomBottomButton(
    selected: Boolean,
    icon: ImageVector,
    label: String
) {

    BottomNavigationItem(
        selected = selected,
        onClick = { /*TODO*/ },
        icon = { Icon(icon, contentDescription = null) }, label =
        {
            Text(text = label)
        }
    )


}


@Composable
private fun HomeScreenContent(
    paddingValues: PaddingValues,
    state: HomeViewState
) {
    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
                .padding(paddingValues)
        ) {
            Spacer(modifier = Modifier.height(40.dp))
            SearchInput()
            BrowseThemesSection(
                state.plantThemes
            )

            HomeGardenSection(
                state.homeGardenItem
            )

        }
    }
}

@Composable
private fun HomeGardenSection(
    homeGardenThemes: List<PlantTheme>
) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {
        Text(
            text = "Design your home garden",
            style = MaterialTheme.typography.h1,
            modifier = Modifier
                .paddingFromBaseline(
                    top = 40.dp,
                    bottom = 16.dp
                )
                .weight(1F)
        )
        Icon(
            Icons.Default.FilterList, contentDescription = null,
            modifier = Modifier
                .size(24.dp)
        )
    }

    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .padding(bottom = 16.dp)
    ) {
        homeGardenThemes.forEach { theme ->
            HomeGardenListItem(theme)
        }
    }

}

@Composable
private fun BrowseThemesSection(themes: List<PlantTheme>) {
    Text(
        text = "Browse themes",
        style = MaterialTheme.typography.h1,
        modifier = Modifier
            .paddingFromBaseline(32.dp)
            .padding(horizontal = 16.dp)
    )

    Spacer(modifier = Modifier.height(16.dp))
    Row(
        // between each card we put 8 spacing
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.horizontalScroll(rememberScrollState())
    ) {
        themes.forEach { theme ->
            PlantThemeCard(theme)
        }
    }
}

@Composable
private fun SearchInput() {
    OutlinedTextField(
        value = "",
        onValueChange = {},
        label = { Text("Search") },
        leadingIcon = {
            Icon(
                Icons.Default.Search,
                contentDescription = null,
                modifier = Modifier.size(18.dp)
            )
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    )
}

@Preview
@Composable
private fun PreviewLightHomeScreen() {
    val previewState = HomeViewState(
        plantThemes = defaultPlantTheme,
        homeGardenItem = homeGardenThemes
    )
    ComposeTheme(darkTheme = false) {
        HomeScreenScaffold(previewState)
    }
}

@Preview
@Composable
private fun PreviewDarkHomeScreen() {
    val previewState = HomeViewState(
        plantThemes = defaultPlantTheme,
        homeGardenItem = homeGardenThemes
    )
    ComposeTheme(darkTheme = true) {
        HomeScreenScaffold(previewState)
    }
}