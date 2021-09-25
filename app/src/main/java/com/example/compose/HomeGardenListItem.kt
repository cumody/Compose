package com.example.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.ui.theme.ComposeTheme

@Composable
fun HomeGardenListItem(plantTheme: PlantTheme) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically
        , modifier = Modifier.fillMaxWidth()
    ) {
        PlantImage(plantTheme)


        Column {
            TitleDescriptionCheckboxRow(plantTheme)
            Divider()
        }

    }
}

@Composable
private fun TitleDescriptionCheckboxRow(plantTheme: PlantTheme) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        TitleAndDescription(plantTheme)
        PlantCheckBox()
    }
}

@Composable
private fun PlantCheckBox() {
    var checkboxState by remember {
        mutableStateOf(false)
    }
    Checkbox(checked = checkboxState,
        onCheckedChange = { isChecked ->
            checkboxState = isChecked
        } ,
    colors = CheckboxDefaults.colors(
        checkmarkColor = MaterialTheme.colors.background
    ))

}

@Composable
private fun RowScope.TitleAndDescription(plantTheme: PlantTheme) {
    Column(
        modifier = Modifier.weight(1F)
    ) {
        Text(
            text = plantTheme.title,
            style = MaterialTheme.typography.h2,
            modifier = Modifier.paddingFromBaseline(top = 24.dp)

        )

        Text(
            text = "This is a description",
            style = MaterialTheme.typography.body1,
            modifier = Modifier.paddingFromBaseline(bottom = 24.dp)
        )
    }
}

@Composable
private fun PlantImage(plantTheme: PlantTheme) {
    Image(
        painterResource(id = plantTheme.imageRes),
        contentDescription = "${plantTheme.title} Image",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(64.dp)
            .clip(MaterialTheme.shapes.small),

        )
}

@Preview
@Composable
private fun PreviewDarkListItem() {
    ComposeTheme(darkTheme = true) {

        Surface(
            color = MaterialTheme.colors.background
        ) {
            HomeGardenListItem(plantTheme = homeGardenThemes.first())

        }

    }
}

@Preview
@Composable
private fun PreviewLightListItem() {
    ComposeTheme(darkTheme = false) {

        Surface(
            color = MaterialTheme.colors.background
        ) {
            HomeGardenListItem(plantTheme = homeGardenThemes.first())

        }

    }
}