package de.rbn.speedcalctrainer

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.material3.MaterialTheme as Material3Theme

@Composable
actual fun getMaterialButton(onClick: () -> Unit, text: String) {
    return Button(onClick = onClick) {
        Text(text)
    }
}

@Composable
actual fun getMaterialText(
    text: String,
    style: TextStyle,
    color: Color,
    modifier: Modifier
) {
    val androidStyle = when (style) {
        MaterialTheme.typography.h1 -> Material3Theme.typography.headlineLarge
        MaterialTheme.typography.h2 -> Material3Theme.typography.headlineMedium
        MaterialTheme.typography.h3 -> Material3Theme.typography.headlineSmall
        MaterialTheme.typography.body1 -> Material3Theme.typography.bodyLarge
        MaterialTheme.typography.body2 -> Material3Theme.typography.bodyMedium
        else -> style
    }

    val androidColor = when (color) {
        MaterialTheme.colors.primary -> Material3Theme.colorScheme.primary
        MaterialTheme.colors.secondary -> Material3Theme.colorScheme.secondary
        MaterialTheme.colors.onPrimary -> Material3Theme.colorScheme.onPrimary
        MaterialTheme.colors.onSecondary -> Material3Theme.colorScheme.onSecondary
        MaterialTheme.colors.background -> Material3Theme.colorScheme.background
        MaterialTheme.colors.onBackground -> Material3Theme.colorScheme.onBackground
        MaterialTheme.colors.surface -> Material3Theme.colorScheme.surface
        MaterialTheme.colors.onSurface -> Material3Theme.colorScheme.onSurface
        MaterialTheme.colors.error -> Material3Theme.colorScheme.error
        MaterialTheme.colors.onError -> Material3Theme.colorScheme.onError
        else -> color
    }

    return Text(
        text = text,
        style = androidStyle,
        color = androidColor,
        modifier = modifier
    )
}


@Composable
actual fun getMaterialOutlinedTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier,
    label: String,
    keyboardOptions: KeyboardOptions,
    keyboardActions: KeyboardActions,
    singleLine: Boolean
) {
    return OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        label = { Text(label) },
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        singleLine = singleLine
    )
}