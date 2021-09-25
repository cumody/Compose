package com.example.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.compose.ui.theme.ComposeTheme
import com.example.compose.ui.theme.Pink900
import com.example.compose.ui.theme.White

@Composable
fun WelcomeScreen(navController: NavController) {

    Surface(
        color = MaterialTheme.colors.primary,
        modifier = Modifier
            .fillMaxSize()

    ) {

        WelcomeBackground()

        WelcomeScreenContent(navController)
    }
}

@Composable
private fun WelcomeScreenContent(navController: NavController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.height(72.dp))
        LeafImage()
        Spacer(modifier = Modifier.height(48.dp))
        LogoImage()
        AppSubtitle()
        Spacer(modifier = Modifier.height(40.dp))
        CreateAccountButton()
        Spacer(modifier = Modifier.height(8.dp))
        LoginButton(navController)

    }
}

@Composable
private fun LeafImage() {
    val isLight = MaterialTheme.colors.isLight

    val leafImageRes = if (isLight) {
        R.drawable.ic_light_welcome_illos
    } else {
        R.drawable.ic_dark_welcome_illos
    }


    Image(
        painter = painterResource(id = leafImageRes),
        contentDescription = null,
        Modifier.offset(x = 88.dp)
    )
}

@Composable
private fun LogoImage() {
    val isLight = MaterialTheme.colors.isLight
    val logoImageRes = if (isLight) {
        R.drawable.ic_light_logo
    } else R.drawable.ic_dark_logo

    Image(
        painter = painterResource(id = logoImageRes),
        contentDescription = "Compose"
    )
}

@Composable
private fun AppSubtitle() {
    Text(
        text = "Beautiful home garden solutions",
        style = MaterialTheme.typography.subtitle1,
        modifier = Modifier.paddingFromBaseline(32.dp)
    )
}

@Composable
private fun CreateAccountButton() {
  
    ComposeSecondaryButton(buttonText = "Create Account", onClick = {})
}

@Composable
private fun LoginButton(navController: NavController) {
    val isLight = MaterialTheme.colors.isLight
    val textColor = if (isLight) {
        Pink900
    } else White
    TextButton(onClick = { navController.navigate("Login") }, modifier = Modifier.fillMaxWidth()) {
        Text(text = "Log in ", color = textColor)
    }
}

@Composable
private fun WelcomeBackground() {
    val isLight = MaterialTheme.colors.isLight
    val backgroundImageRes = if (isLight) {
        R.drawable.ic_light_welcome_bg
    } else {
        R.drawable.ic_dark_welcome_bg
    }
    Image(
        painterResource(id = backgroundImageRes),
        contentDescription = null,
        contentScale = ContentScale.FillBounds,
        modifier = Modifier.fillMaxSize()
    )
}

@Preview
@Composable
private fun PreviewDarkWelcomeScreen() {
    ComposeTheme(darkTheme = true) {
        WelcomeScreen(rememberNavController())
    }
}

@Preview
@Composable
private fun PreviewLightWelcomeScreen() {
    ComposeTheme(darkTheme = false) {
        WelcomeScreen(rememberNavController())
    }
}