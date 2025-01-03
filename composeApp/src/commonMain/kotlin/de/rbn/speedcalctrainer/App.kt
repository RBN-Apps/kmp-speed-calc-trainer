package de.rbn.speedcalctrainer

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlin.random.Random


@Composable
fun App(modifier: Modifier = Modifier) {
    var number1 by remember { mutableIntStateOf(1) }
    var number2 by remember { mutableIntStateOf(1) }
    var userInput by remember { mutableStateOf(TextFieldValue("")) }
    var feedback by remember { mutableStateOf("") }
    var showFeedback by remember { mutableStateOf(false) }
    var range1Start by remember { mutableStateOf("2") }
    var range1End by remember { mutableStateOf("9") }
    var range2Start by remember { mutableStateOf("2") }
    var range2End by remember { mutableStateOf("9") }

    fun updateNumbers() {
        val start1 = range1Start.toIntOrNull() ?: 2
        val end1 = range1End.toIntOrNull() ?: 9
        val start2 = range2Start.toIntOrNull() ?: 2
        val end2 = range2End.toIntOrNull() ?: 9

        number1 = Random.nextInt(start1, end1 + 1)
        number2 = Random.nextInt(start2, end2 + 1)
    }

    LaunchedEffect(Unit) {
        updateNumbers()
    }

    fun handleSubmit() {
        val correctAnswer = number1 * number2
        val userAnswer = userInput.text.toIntOrNull()

        feedback = if (userAnswer == correctAnswer) {
            "Correct! 🎉"
        } else {
            "Incorrect. $number1 x $number2 = $correctAnswer."
        }

        userInput = TextFieldValue("")
        showFeedback = true
        updateNumbers()
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(16.dp))

        getMaterialText(
            text = "SpeedCalc Training",
            style = MaterialTheme.typography.h1,
            color = MaterialTheme.colors.primary
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Eingabebereiche für die Zahlen
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.Top
        ) {
            // Bereich für Zahl 1
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                getMaterialText("Range for Number 1", style = MaterialTheme.typography.body2)
                Spacer(modifier = Modifier.height(8.dp))
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    getMaterialOutlinedTextField(
                        value = range1Start,
                        onValueChange = {
                            if (it.isEmpty() || it == "-" || it.toIntOrNull() != null) {
                                range1Start = it
                                val min = it.toIntOrNull()
                                val max = range1End.toIntOrNull()
                                if (min != null && max != null && min > max) {
                                    range1End = it
                                }
                                updateNumbers()
                            }
                        },
                        label = "Min",
                        modifier = Modifier.width(70.dp),
                        keyboardOptions = KeyboardOptions.Default.copy(
                            keyboardType = KeyboardType.Number,
                            imeAction = androidx.compose.ui.text.input.ImeAction.Done
                        )
//                        keyboardActions = KeyboardActions(
//                            onDone = { handleSubmit() }
//                        )
                    )
                    getMaterialOutlinedTextField(
                        value = range1End,
                        onValueChange = {
                            if (it.isEmpty() || it == "-" || it.toIntOrNull() != null) {
                                range1End = it
                                val min = range1Start.toIntOrNull()
                                val max = it.toIntOrNull()
                                if (min != null && max != null && max < min) {
                                    range1Start = it
                                }
                                updateNumbers()
                            }
                        },
                        label = "Max",
                        modifier = Modifier.width(70.dp),
                        keyboardOptions = KeyboardOptions.Default.copy(
                            keyboardType = KeyboardType.Number,
                            imeAction = androidx.compose.ui.text.input.ImeAction.Done
                        )
//                        keyboardActions = KeyboardActions(
//                            onDone = { handleSubmit() }
//                        )
                    )
                }
            }

            Spacer(modifier = Modifier.width(16.dp))

            // Bereich für Zahl 2
            Column(horizontalAlignment = Alignment.CenterHorizontally) {

                getMaterialText("Range for Number 2", style = MaterialTheme.typography.body2)
                Spacer(modifier = Modifier.height(8.dp))
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    getMaterialOutlinedTextField(
                        value = range2Start,
                        onValueChange = {
                            if (it.isEmpty() || it == "-" || it.toIntOrNull() != null) {
                                range2Start = it
                                val min = it.toIntOrNull()
                                val max = range2End.toIntOrNull()
                                if (min != null && max != null && min > max) {
                                    range2End = it
                                }
                                updateNumbers()
                            }
                        },
                        label = "Min",
                        modifier = Modifier.width(70.dp),
                        keyboardOptions = KeyboardOptions.Default.copy(
                            keyboardType = KeyboardType.Number,
                            imeAction = androidx.compose.ui.text.input.ImeAction.Done
                        )
//                        keyboardActions = KeyboardActions(
//                            onDone = { handleSubmit() }
//                        )
                    )
                    getMaterialOutlinedTextField(
                        value = range2End,
                        onValueChange = {
                            if (it.isEmpty() || it == "-" || it.toIntOrNull() != null) {
                                range2End = it
                                val min = range2Start.toIntOrNull()
                                val max = it.toIntOrNull()
                                if (min != null && max != null && max < min) {
                                    range2Start = it
                                }
                                updateNumbers()
                            }
                        },
                        label = "Max",
                        modifier = Modifier.width(70.dp),
                        keyboardOptions = KeyboardOptions.Default.copy(
                            keyboardType = KeyboardType.Number,
                            imeAction = androidx.compose.ui.text.input.ImeAction.Done
                        )
//                        keyboardActions = KeyboardActions(
//                            onDone = { handleSubmit() }
//                        )
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        getMaterialText(
            text = "What is $number1 x $number2?",
            style = MaterialTheme.typography.h2
        )

        Spacer(modifier = Modifier.height(16.dp))

        getMaterialOutlinedTextField(
            value = userInput.text,
            onValueChange = { userInput = TextFieldValue(it) },
            label = "Your Answer",
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = androidx.compose.ui.text.input.ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = { handleSubmit() }
            ),
            modifier = Modifier.fillMaxWidth(0.6f)
        )

        Spacer(modifier = Modifier.height(16.dp))

        getMaterialButton(onClick = { handleSubmit() }, text = "Submit")

        Spacer(modifier = Modifier.height(16.dp))

        // Feedback Animation
        LaunchedEffect(showFeedback) {
            if (showFeedback) {
                delay(2000) // Feedback nach 2 Sekunden ausblenden
                showFeedback = false
            }
        }

        AnimatedVisibility(
            visible = showFeedback,
            enter = fadeIn(animationSpec = tween(500)) + slideInVertically(initialOffsetY = { -50 }),
            exit = fadeOut(animationSpec = tween(500)) + slideOutVertically(targetOffsetY = { -50 })
        ) {
            getMaterialText(
                text = feedback,
                style = MaterialTheme.typography.body1,
                color = if (feedback.startsWith("Correct")) Color.Green else Color.Red,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}