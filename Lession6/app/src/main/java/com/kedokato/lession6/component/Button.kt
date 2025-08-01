package com.kedokato.lession6.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.getCurrentColorScheme


@Composable
fun Button(
    text: String,
    modifier: Modifier,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier.fillMaxWidth(0.9f)
            .height(56.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = getCurrentColorScheme().primary,
            contentColor = getCurrentColorScheme().onPrimary
        )
    ) {
        androidx.compose.material3.Text(text)
    }
}


@Preview
@Composable
fun ButtonPreview() {
    Button(
        text = "Login",
        modifier = Modifier,
        onClick = {}
    )
}