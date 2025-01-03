package de.rbn.speedcalctrainer

import androidx.compose.material.Text
import androidx.compose.material.Button
import androidx.compose.runtime.Composable

@Composable
actual fun getMaterialButton(onClick: () -> Unit, text: String) {
    return Button(onClick = onClick) {
        Text(text)
    }
}