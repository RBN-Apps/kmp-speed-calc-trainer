package de.rbn.speedcalctrainer

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Speed Calc Trainer",
    ) {
        App()
    }
}