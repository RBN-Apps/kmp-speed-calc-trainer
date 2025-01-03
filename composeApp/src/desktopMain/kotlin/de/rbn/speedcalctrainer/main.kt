package de.rbn.speedcalctrainer

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Speed Calc Trainer",
        state = WindowState(width = 800.dp, height = 700.dp),
        icon = painterResource("speedcalcicon.png")
    ) {
        App()
    }
}