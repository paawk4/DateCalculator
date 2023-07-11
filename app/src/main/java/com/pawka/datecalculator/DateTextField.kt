package com.pawka.datecalculator

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.time.LocalDate
import java.time.Period

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DateTextField(date: String) {
    var day = "00"
    var month = "00"
    var year = "0000"

    if (date.isNotEmpty()) {
        if (date.length > 2) {
            day = date.substring(0, 2)

            if (date.length > 4) {
                month = date.substring(2, 4)
            }
            if (date.length > 7) {
                year = date.substring(4, 8)
            }
        } else day = date
    }

    Row(
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        val focusManager = LocalFocusManager.current
        TextField(
            modifier = Modifier.width(90.dp),
            value = day,
            onValueChange = {
                if (it.length > 2) {
                    focusManager.moveFocus(FocusDirection.Next)
                }
            },
            singleLine = true,
            textStyle = TextStyle(fontSize = 42.sp, textAlign = TextAlign.Center),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                autoCorrect = false
            )
        )
        Text(text = "/", fontSize = 42.sp)
        TextField(
            modifier = Modifier.width(90.dp),
            value = month,
            onValueChange = {
                if (it.length > 2) {
                    focusManager.moveFocus(FocusDirection.Next)
                }
            },
            singleLine = true,
            textStyle = TextStyle(fontSize = 42.sp, textAlign = TextAlign.Center),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                autoCorrect = false
            )
        )
        Text(text = "/", fontSize = 42.sp)
        TextField(
            modifier = Modifier.width(150.dp),
            value = year,
            onValueChange = {
                if (it.length > 4) {
                    focusManager.moveFocus(FocusDirection.Down)
                }
            },
            singleLine = true,
            textStyle = TextStyle(fontSize = 40.sp, textAlign = TextAlign.Center),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                autoCorrect = false
            )
        )
    }
}