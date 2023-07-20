package com.pawka.datecalculator.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.pawka.datecalculator.presentation.DateDefaults.DATE_MASK

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DateTextField(date: String) {
    Box {
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

        Box(
            modifier = Modifier
                .matchParentSize()
                .alpha(0f)
                .clickable(onClick = {}),
        )
    }

}


object DateDefaults {
    const val DATE_MASK = "##/##/####"
    const val DATE_LENGTH = 8
}