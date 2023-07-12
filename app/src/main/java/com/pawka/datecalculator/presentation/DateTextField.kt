package com.pawka.datecalculator.presentation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.pawka.datecalculator.presentation.DateDefaults.DATE_MASK

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DateTextField(date: String) {
    TextField(
        value = date,
        modifier = Modifier.fillMaxWidth(),
        onValueChange = {},
        textStyle = TextStyle(fontSize = 42.sp, textAlign = TextAlign.End),
        readOnly = true,
        keyboardOptions = KeyboardOptions(
            autoCorrect = false
        ),
        visualTransformation = MaskVisualTransformation(DATE_MASK)
    )
}


object DateDefaults {
    const val DATE_MASK = "##/##/####"
    const val DATE_LENGTH = 8
}