package com.example.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.ui.theme.ComposeTheme

@Composable
@Stable
fun PlantThemeCard(plantTheme: PlantTheme) {
    Card(
        shape = MaterialTheme.shapes.small,
    ) {
        Column(verticalArrangement = Arrangement.SpaceEvenly) {
            Image(
                painter = painterResource(id = plantTheme.imageRes),
                contentDescription = "${plantTheme.title} Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(96.dp)
                    .width(136.dp)
            )

            Text(
                text = plantTheme.title,
                style = MaterialTheme.typography.h2,
                modifier = Modifier
                    .paddingFromBaseline(top = 24.dp)
                    .padding(horizontal = 16.dp)
            )

        }
    }

}

@Preview
@Composable
private fun PreviewDarkThemeCard() {
    ComposeTheme(darkTheme = true) {
        PlantThemeCard(plantTheme = defaultPlantTheme.first())
    }
}

@Preview
@Composable
private fun PreviewLightThemeCard() {
    ComposeTheme(darkTheme = false) {
        PlantThemeCard(plantTheme = defaultPlantTheme.first())
    }
}

