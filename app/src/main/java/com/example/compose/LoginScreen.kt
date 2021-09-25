package com.example.compose

import android.widget.Space
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.compose.ui.theme.ComposeTheme

@Composable
fun LoginScreen(navController: NavController) {
    Surface(color = MaterialTheme.colors.background, modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LoginHeader()

            EmailInput()

            Spacer(modifier = Modifier.height(8.dp))

            PasswordInput()

            TermsOfServiceLabel()

            Spacer(modifier = Modifier.height(16.dp))

            LoginButton(navController)


        }


    }
}

@Composable
private fun TermsOfServiceLabel() {
    Text(
        text = "By clicking below you agree to our Terms of Use and consent to our Privacy Policy.",
        style = MaterialTheme.typography.body2,
        modifier = Modifier.paddingFromBaseline(top = 24.dp),
        textAlign = TextAlign.Center
    )
}

@Composable
private fun LoginButton(navController: NavController) {
    ComposeSecondaryButton(
        buttonText = "Log in",
        onClick = {
            navController.navigate("Home")
        }
    )
}

@Composable
private fun PasswordInput() {
    val textState = remember {
        mutableStateOf("")
    }
    OutlinedTextField(
        value = textState.value,
        onValueChange = { nextString ->
            textState.value = nextString
        },
        label = { Text(text = "Password (8+ Characters)") },
        modifier = Modifier.fillMaxWidth(),
        singleLine = true ,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password) ,
        visualTransformation = PasswordVisualTransformation()

    )
}

@Composable
private fun EmailInput() {
    val textState = remember {
        mutableStateOf("")
    }
    OutlinedTextField(
        value = textState.value, onValueChange = { nextString ->
            textState.value = nextString
        },
        label = { Text(text = "Email Address") },
        modifier = Modifier.fillMaxWidth() ,
        maxLines = 1 ,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
    )
}

@Composable
private fun LoginHeader() {
    Text(
        text = "Login in with email", style = MaterialTheme.typography.h1,
        modifier = Modifier.paddingFromBaseline(top = 184.dp, bottom = 8.dp)
    )
}

@Preview
@Composable
private fun PreviewDarkLoginScreen() {
    ComposeTheme(darkTheme = true) {
        LoginScreen(rememberNavController())
    }
}

@Preview
@Composable
private fun PreviewLightLoginScreen() {
    ComposeTheme(darkTheme = false) {
        LoginScreen(rememberNavController())
    }
}