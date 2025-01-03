package de.rbn.speedcalctrainer

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle


@Composable
expect fun getMaterialButton(onClick: () -> Unit, text: String)

@Composable
expect fun getMaterialText(text: String, style: TextStyle, color: Color = Color.Unspecified, modifier: Modifier = Modifier)

@Composable
expect fun getMaterialOutlinedTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    label: String,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
)