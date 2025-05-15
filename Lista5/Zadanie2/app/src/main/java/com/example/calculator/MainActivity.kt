package com.example.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculator.ui.theme.CalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalculatorTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    SimpleCalculator()
                }
            }
        }
    }
}

@Composable
fun SimpleCalculator() {
    var number1 by rememberSaveable { mutableStateOf("") }
    var number2 by rememberSaveable { mutableStateOf("") }
    var result by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = number1,
            onValueChange = { number1 = it },
            label = { Text("Enter First Number") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = number2,
            onValueChange = { number2 = it },
            label = { Text("Enter Second Number") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(onClick = {
                result = calculate(number1, number2) { a, b -> a + b }
            }) {
                Text("+")
            }

            Button(onClick = {
                result = calculate(number1, number2) { a, b -> a - b }
            }) {
                Text("-")
            }

            Button(onClick = {
                result = calculate(number1, number2) { a, b -> a * b }
            }) {
                Text("×")
            }

            Button(onClick = {
                result = calculate(number1, number2) { a, b ->
                    if (b == 0) throw ArithmeticException("a/0")
                    a / b
                }
            }) {
                Text("÷")
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Result: $result",
            fontSize = 30.sp,
        )
    }
}

fun calculate(n1: String, n2: String, operation: (Int, Int) -> Int): String {
    return try {
        val a = n1.toInt()
        val b = n2.toInt()
        operation(a, b).toString()
    } catch (e: NumberFormatException) {
        "Invalid input"
    } catch (e: ArithmeticException) {
        "Cannot divide by 0"
    }
}